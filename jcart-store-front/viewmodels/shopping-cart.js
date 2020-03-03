var app = new Vue({
    el: '#app',
    data: {

        myShoppingCart: []
    },
    mounted() {
        console.log('view mounted');
        /*var myShoppingCart = localStorage['myShoppingCart'];
        this.myProducts = JSON.parse(myShoppingCart);
        //console.log(myShoppingCart);*/

        var myShoppingCartJson = localStorage['myShoppingCartJson'];
        this.myShoppingCart = JSON.parse(myShoppingCartJson);
    }
})