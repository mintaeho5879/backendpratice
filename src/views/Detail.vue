
<script setup>
import httpService from '@/services/HttpService';
import { onMounted, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute(); // pathVariable객체를 가져오기 위함. 
const router = useRouter(); //주소 이동

const state = reactive({
    memo: {
        id: 0,
        title: '',
        content: '',
        createdAt: ''
    }
});

onMounted(async () => {
  const id = route.params.id;
  const data = await httpService.findById(id);
  state.memo = data.resultData;
})

const moveToForm = () => {
  const json = JSON.stringify(state.memo);

  router.push({
    path: '/memo/add',
    state: {
      data: json
    }
  })
}

</script>

<template>
    <div class="mb-3">
      등록일시: {{ state.memo.createdAt }}
    </div>
    <div class="mb-3">
      제목: {{  state.memo.createdAt }}
    </div>
    <div class="mb-3">
      내용: {{  state.memo.content }}
    </div>
    <button @click="moveToForm" type="button" class="btn btn-primary w-100 py-3">수정</button>
    
</template>

<style scoped>
</style>