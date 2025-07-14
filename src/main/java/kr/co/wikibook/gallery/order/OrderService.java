package kr.co.wikibook.gallery.order;


import kr.co.wikibook.gallery.cart.CartMapper;
import kr.co.wikibook.gallery.item.ItemMapper;
import kr.co.wikibook.gallery.item.ItemService;
import kr.co.wikibook.gallery.item.model.ItemGetRes;
import kr.co.wikibook.gallery.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final ItemMapper itemMapper;
    private final CartMapper cartMapper;

    @Transactional
    public int saveOrder(OrderPostReq req, int logginedMemberId) {
        // 상품 정보 DB로 부터 가져온다.
        List<ItemGetRes> itemList = itemMapper.findAllByIdIn(req.getItemIds());
        log.info("itemList:{}", itemList);

        //총 구매가격 콘솔에 출력!!!
        long amount = 0;
        for (ItemGetRes item : itemList) {
            amount += item.getPrice() - (item.getPrice() * item.getDiscountPer() /100);
        }
        log.info("result:{}", amount);
        // 만드세요! OrderPostDto 객체화하시고 데이터 넣어주세요.
        OrderPostDto orderPostDto = new OrderPostDto();
        orderPostDto.setMemberId(logginedMemberId);
        orderPostDto.setName(req.getName());
        orderPostDto.setAddress(req.getAddress());
        orderPostDto.setPayment(req.getPayment());
        orderPostDto.setCardNumber(req.getCardNumber());
        orderPostDto.setAmount(amount);
        log.info("before-orderPostDto:{}", orderPostDto);
        int result = orderMapper.save(orderPostDto);
        log.info("after-orderPostDto:{}", orderPostDto);
        OrderItemPostDto orderItemPostDto = new OrderItemPostDto(orderPostDto.getOrderId(),req.getItemIds());

        int resultDetail = orderItemMapper.save(orderItemPostDto);

        cartMapper.deleteByMemberId(logginedMemberId);

        return 1;

        }

    public List<OrderGetRes> getOrders(int memberId) {
        return orderMapper.findAllByMemberIdOrderByIdDesc(memberId);
    }
    public OrderDetailGetRes detail(OrderDetailGetReq req) {
        OrderDetailGetRes result = orderMapper.findByOrderIdAndMemberId(req);
        List<OrderDetailDto> items = orderItemMapper.findAllByOrderId(req.getOrderId());
        result.setItems(items);
        log.info("result:{}", result);
        return result;
    }
}
