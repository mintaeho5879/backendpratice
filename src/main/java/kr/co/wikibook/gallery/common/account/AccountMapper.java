package kr.co.wikibook.gallery.common.account;

import kr.co.wikibook.gallery.common.account.model.AccountLoginReq;
import kr.co.wikibook.gallery.common.account.model.AccountLoginRes;
import kr.co.wikibook.gallery.item.model.ItemGetRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
 AccountLoginRes findByLoginAndLoginPw(AccountLoginReq Req);
}
