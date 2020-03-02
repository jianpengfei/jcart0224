var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: ''
    },
    methods: {
        handleLoginClick(){
            console.log('login click');
            this.loginAdministrator();
        },
        loginAdministrator() {
            axios.get('/administrator/login', {
                params: {
                    username: this.username,
                    password: this.password
                }
            })
                .then(function (response) {
                    console.log(response);
                    var dto = response.data;
                    //浏览器的存储 (key/value存储)
                    //1 cookie 磁盘上 大小限制受限
                    //2 localStorage 磁盘上 持久化 大小限制上  ,远大于cookie, 安全性比cookie好
                    //3 sessionStorage 内存
                    localStorage['jcartToken'] = dto.token;
                    localStorage['expireTimestamp'] = dto.expireTimestamp;
                    alert('登陆成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})