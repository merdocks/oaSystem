<template>
  <div>
    <div>账号切换</div>
    <button @click="wjl()" type="default" size="mini">王经理</button>
    <button @click="lrsjl()" type="default" size="mini">李人事经理</button>
    <button @click="zhangsan()" type="default" size="mini">张总经理</button>
    <button @click="admin()" type="default" size="mini">admin</button>
    <div>当前token：{{ token }}</div>
  </div>
</template>

<script>
export default {
  name: "Test",

  data() {
    return {
      token: ''
    };
  },

  created(){
    this.token = window.localStorage.getItem('token')
  },

  methods: {
     admin() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLMwNDc0tjAz0lEqLU4t8kwBikGYeYm5qUAtiSm5mXlKtQAcAwFyQgAAAA.v9PbGBhEqtpxChvO30n4CIwPm0Bo5puKxePsIP1Gb01ZhMSLxduo9jOpdzl2viq-NM0DfcUdAkV0Vkhb9HxZow'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },
    wjl() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDM3NjMwNDIx1FEqLU4t8kxRsjKCMPMSc1OBWsqzcpRqAb4pVZBAAAAA.-bW4hJ5UptFiCRsL6jVUa4XbgVwdsfVGfP8gJ-tOVbp7D3JOb8sylbBDLUhTZt6FJsYhlA5uYz8HSRck_pbaCA'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    lrsjl() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDM3NjMwNDY10VEqLU4t8kxRsjKGMPMSc1OBWnKKirNylGoBjn551kIAAAA.HiQAK2uUQCFlQilO3mR3p5TURrlMrjN7zrR1IcFqhU8Q-VyxUiRJrGIuSwSKOC1uyQH_4JXL99yGDq74OnKvXQ'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    zhangsan() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNLMwNDc0tjSz0FEqLU4t8kxRsjKHMPMSc1OBWqoyEvPSixPzlGoBb30cUEUAAAA.tn-2JPdt00eOJxaR__zFK8h-MJyIUt2aVAPfi0iOUlcGyo4eEYRrnQUA-cA7ADcsuV233iaZ8tP5AnM5kd3E4w'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    },

    lisi() {
      window.localStorage.setItem('token', '');
      let token = 'eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJScgwN8dANDXYNUtJRSq0oULIyNDM3NjMwNDGy0FEqLU4t8kxRsjKBMPMSc1OBWnIyizOVagHMg0O1QQAAAA.bQBo4zc1rtT0b6Mq3OmuM6cq3Oe2RpA01GR77Pql84W3ojhdEcjLF2z5ZQfTuoCEkA45ZeXOVqXmSJa3TXfe5g'
      window.localStorage.setItem('token', token);
      this.token = window.localStorage.getItem('token')
    }
  }
}
</script>
