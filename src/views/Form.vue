
<script setup>
import httpService from '@/services/HttpService';
import { reactive, onMounted } from 'vue';
import { useRouter } from 'vue-router';

// pathVariable객체를 가져오기 위함. 
const router = useRouter(); //주소 이동

const state = reactive({
    memo: {
        id: 0,
        title: '',
        content: '',
        createdAt: ''
    }
});

onMounted(() => {
    const passData = history.state.data;
    console.log('passData:', passData);
    if(history.state.data) { //넘어온 데이터가 있다.
        console.log('history.state.data:', history.state.data);
        state.memo = JSON.parse(history.state.data); //JSON to Object
    }
})
const procSubmit = async () => {
    const jsonBody = {
        title: state.memo.title,
        content: state.memo.content
    }
    const data = await httpService.save(jsonBody);
    if(data.resultData === 1) {
        //주소가 "/"로 라우팅처리 하고싶다.
        router.push({ path: '/'});
    } else {
        alert(data.resultMessage);
    }

}

</script>

<template>
  <form class="detail" @submit.prevent="procSubmit">
    <div class="mb-3" v-if="state.memo.createdAt">
      등록일시: {{ state.memo.createdAt }}
    </div>
    <div class="mb-3">
      <label for="title" class="form-label">제목</label>
      <input type="text" id="title" class="form-control p-3" v-model="state.memo.title" />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용</label>
      <textarea id="content" class="form-control p-3" v-model="state.memo.content"></textarea>
    </div>
    <button type="submit" class="btn btn-primary w-100 py-3">{{state.memo.id > 0 ?'수정':'저장'}}</button>
  </form>
</template>

<style scoped>
</style>