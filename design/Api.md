## 0.1 查询产品列表

URL: /product/search?productName={productName}&price=price&storkQuantity={storkQuantity}&status={status}&pageNum={pageNum}  
Method：GET  

ResponseBody:  
```json
[
    {
        "total": 5,
        "pageSize": 5,
        "pageNum": 5,
        "list":
        [
            {
                "productId":1234,
                "productName": "product001",
                "productCode": "0000000001",
                "price": 99.99,
                "discount": 0.99,
                "storkQuantity": 500,
                "status": 1,
                "sortOrder": 0,
                "rewardPoints": 100,
                "mainPicUrl": "http://xxx.com/image01.jpg",
                "productAbstract": "摘要1"
            },
            {
                "productId":1234,
                "productName": "product002",
                "productCode": "0000000002",
                "price": 99.99,
                "discount": 0.99,
                "storkQuantity": 500,
                "status": 1,
                "sortOrder": 0,
                "rewardPoints": 100,
                "mainPicUrl": "http://xxx.com/image02.jpg",
                "productAbstract": "摘要2"
            }
        ]

    }
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productName   | String   | 商品名称    |
| price   | String   | 价格    |
| storkQuantity   | String   | 库存   |
| status   | integer   | 状态    |
| pageNum   | integer   | 页码    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer   | 产品Id    |
| productName   | String   | 产品名称    |
| productCode   | String   | 产品代码    |
| price   | double   | 价格    |
| discount   | double   | 打折    |
| storkQuantity   | Integer   | 库存    |
| status   | byte   | 状态    |
| sortOrder   | Integer   | 排序    |
| rewardPoints   | Integer   | 积分    |
| mainPicUrl   | String   | 主图    |
| productAbstract   | String   | 摘要    |




## 0.2 添加产品

URL: /product/create  
Method：POST  


ResponseBody:  
```json
{
    "productName": "product001",
    "productCode": "0000000001",
    "price": 99.99,
    "discount": 0.99,
    "storkQuantity": 1,
    "starts": 0,
    "mainPicUrl": "http://xxx.com/image02.jpg",
    "productDescription": "商品描述",
    "otherPicUrl": "http://xxx.com/image03.jpg"
    
}

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productName   | String   | 产品名称    |
| productCode   | String   | 产品代码    |
| price   | double   | 价格    |
| discount   | double   | 打折    |
| storkQuantity   | Integer   | 库存    |
| status   | byte   | 状态    |
| mainPicUrl   | String   | 主图    |
| productDescription   | String   |  描述   |
| otherPicUrl   | String   | 附图    |


## 0.3 获取商品

URL: /product/getProduct?productId={productId}
Method：GET  


ResponseBody:  
```json
{
    "productId":1234,
    "productName": "product002",
    "productCode": "0000000002",
    "price": 99.99,
    "discount": 0.99,
    "storkQuantity": 500,
    "status": 1,
    "sortOrder": 0,
    "rewardPoints": 100,
    "mainPicUrl": "http://xxx.com/image02.jpg",
    "productAbstract": "摘要2"
    
}

```

Request Header  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer   | 产品Id    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer   | 产品Id    |
| productName   | String   | 产品名称    |
| productCode   | String   | 产品代码    |
| price   | double   | 价格    |
| discount   | double   | 打折    |
| storkQuantity   | Integer   | 库存    |
| status   | byte   | 状态    |
| sortOrder   | Integer   | 排序    |
| rewardPoints   | Integer   | 积分    |
| mainPicUrl   | String   | 主图    |
| productAbstract   | String   | 摘要    |

## 0.4 更新商品

URL: /product/updateProduct
Method：POST  

RequestHeader:  
{
    "productId":1234 
}


ResponseBody:  
```json
{
    
    "productName": "product002",
    "productCode": "0000000002",
    "price": 99.99,
    "discount": 0.99,
    "storkQuantity": 500,
    "status": 1,
    "sortOrder": 0,
    "rewardPoints": 100,
    "mainPicUrl": "http://xxx.com/image02.jpg",
    "productAbstract": "摘要2"
    
}

```

Request Header  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer   | 产品Id    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productName   | String   | 产品名称    |
| productCode   | String   | 产品代码    |
| price   | double   | 价格    |
| discount   | double   | 打折    |
| storkQuantity   | Integer   | 库存    |
| status   | byte   | 状态    |
| sortOrder   | Integer   | 排序    |
| rewardPoints   | Integer   | 积分    |
| mainPicUrl   | String   | 主图    |
| productAbstract   | String   | 摘要    |


## 1.1 查询客户列表

URL: /customer/search?userName={userName}&email=email&mobile={mobile}&status={status}&pageNum={pageNum}  
Method：GET  

ResponseBody:  
```json
[
    {
        "total": 5,
        "pageSize": 5,
        "pageNum": 5,
        "list":
        [
            {
                "customerId":0001,
                "userName": "user001",
                "realName": "jjj",
                "encryptedPassword": "01010101010101",
                "newsSubscribed": 0,
                "defaultAddressId": 1,
                "email": "123@163.com",
                "emailVerified": 0,
                "mobile": "12345678998",
                "mobileVerified": 0,
                "status": 1,
                "avatarUrl": "http://xxx.com/pic01.jpg"
            },
            {
                "customerId":0002,
                "userName": "user002",
                "realName": "jjj",
                "encryptedPassword": "01010101010101",
                "newsSubscribed": 0,
                "defaultAddressId": 1,
                "email": "456@163.com",
                "emailVerified": 0,
                "mobile": "12345678998",
                "mobileVerified": 0,
                "status": 1,
                "avatarUrl": "http://xxx.com/pic02.jpg"
            }
        ]

    }
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| userName   | String   | 用户名    |
| email   | String   | 邮箱    |
| mobile   | String   | 电话   |
| status   | integer   | 状态    |
| pageNum   | integer   | 页码    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户Id    |
| userName   | String   | 客户名称    |
| realName   | String   | 真实名称    |
| encryptedPassword   | String   | 加密密码    |
| newsSubscribed   | double   | 是否订阅新闻    |
| defaultAddressId   | Integer   | 默认地址Id    |
| email   | String   | 邮箱    |
| emailVerified   | tinyint   | 邮箱验证    |
| mobile   | String   | 手机    |
| mobileVerified   | tinyint   | 手机验证    |
| status   | tinyint   | 状态    |
| avatarUrl   | String   | 头像    |




## 1.2 创建客户

URL: /customer/create  
Method：POST  


ResponseBody:  
```json
{
    "userName": "user002",
    "newsSubscribed": 0,
    "defaultAddressId": 1,
    "email": "456@163.com",
    "emailVerified": 0,
    "mobile": "12345678998",
    "mobileVerified": 0,
    "status": 1,
    "avatarUrl": "http://xxx.com/pic02.jpg"
    
}

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| userName   | String   | 客户名称    |
| newsSubscribed   | double   | 是否订阅新闻    |
| defaultAddressId   | Integer   | 默认地址Id    |
| email   | String   | 邮箱    |
| emailVerified   | tinyint   | 邮箱验证    |
| mobile   | String   | 手机    |
| mobileVerified   | tinyint   | 手机验证    |
| status   | tinyint   | 状态    |
| avatarUrl   | String   | 头像    |


## 1.3 获取客户

URL: /customer/getcustomer?customerId={customerId}
Method：GET  


ResponseBody:  
```json
{
    "userName": "user002",
    "realName": "jjj",
    "encryptedPassword": "01010101010101",
    "newsSubscribed": 0,
    "defaultAddressId": 1,
    "email": "456@163.com",
    "emailVerified": 0,
    "mobile": "12345678998",
    "mobileVerified": 0,
    "status": 1,
    "avatarUrl": "http://xxx.com/pic02.jpg"
    
}

```

Request Header  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户Id    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户Id    |
| userName   | String   | 客户名称    |
| realName   | String   | 真实名称    |
| encryptedPassword   | String   | 加密密码    |
| newsSubscribed   | double   | 是否订阅新闻    |
| defaultAddressId   | Integer   | 默认地址Id    |
| email   | String   | 邮箱    |
| emailVerified   | tinyint   | 邮箱验证    |
| mobile   | String   | 手机    |
| mobileVerified   | tinyint   | 手机验证    |
| status   | tinyint   | 状态    |
| avatarUrl   | String   | 头像    |

## 1.4 更新客户

URL: /customer/updateCustomer
Method：POST  

RequestHeader:  
{
    "customerId":1234 
}


ResponseBody:  
```json
{
    
    "userName": "user002",
    "newsSubscribed": 0,
    "defaultAddressId": 1,
    "email": "456@163.com",
    "emailVerified": 0,
    "mobile": "12345678998",
    "mobileVerified": 0,
    "status": 1,
    "avatarUrl": "http://xxx.com/pic02.jpg"
    
}

```

Request Header  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户Id    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| userName   | String   | 客户名称    |
| newsSubscribed   | double   | 是否订阅新闻    |
| defaultAddressId   | Integer   | 默认地址Id    |
| email   | String   | 邮箱    |
| emailVerified   | tinyint   | 邮箱验证    |
| mobile   | String   | 手机    |
| mobileVerified   | tinyint   | 手机验证    |
| status   | tinyint   | 状态    |
| avatarUrl   | String   | 头像    |


## 2.1 查询订单列表

URL: /order/search?orderId={orderId}&customerId=customerId&totalPrice={totalPrice}&createTime={createTime}&pageNum={pageNum}  
Method：GET  

ResponseBody:  
```json
[
    {
        "total": 5,
        "pageSize": 5,
        "pageNum": 5,
        "list":
        [
            {
                "orderId":0001,
                "customerId": 2,
                "starts": 0,
                "totalPrice": 9999.99,
                "createTime": 1582538621800,
                "defaultAddressId": 1,
                "updateTime": 1582538621800,
                "invoiceAddress": "XXX省XXX市XXX县",
                "shipAddress": "XXX省XXX市XXX县",
                "shipPrice": 11.11,
                "orderProducts": "",
                "productId": 1,
                "productCode": "0101010101",
                "productName": "product001",
                "unitPrice": 99.99,
                "quantity": 100,
                "shipMethod": 1,
                "payMethod": 1,
                "unitRewardPoints": 10,
                "invoicePrice": 99.99
            },
            {
                "orderId":0002,
                "customerId": 2,
                "starts": 0,
                "totalPrice": 9999.99,
                "createTime": 1582538621800,
                "defaultAddressId": 1,
                "updateTime": 1582538621800,
                "invoiceAddress": "XXX省XXX市XXX县",
                "shipAddress": "XXX省XXX市XXX县",
                "shipPrice": 11.11,
                "orderProducts": "",
                "productId": 1,
                "productCode": "0101010101",
                "productName": "product001",
                "unitPrice": 99.99,
                "quantity": 100,
                "shipMethod": 1,
                "payMethod": 1,
                "unitRewardPoints": 10,
                "invoicePrice": 99.99
            }
        ]

    }
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderId   | String   |  订单Id   |
| customerId   | String   | 客户Id    |
| totalPrice   | String   | 总价   |
| createTime   | Long   | 创建时间    |
| pageNum   | integer   | 页码    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderId   | Integer   | 订单Id    |
| customerId   | Integer   | 客户名称    |
| starts   | byte   | 状态    |
| createTime   | Long   | 创建时间    |
| defaultAddressId   | Integer   | 默认地址Id    |
| updateTime   | Long   | 修改时间    |
| invoiceAddress   | String   | 发票地址    |
| shipAddress   | String   | 寄送地址    |
| shipPrice   | double   | 运费    |
| orderProducts   | text   | 商品订单    |
| productId   | Integer   | 商品Id    |
| productCode   | String   | 商品代码    |
| productName   | String   | 商品名称    |
| unitPrice   | double   | 单价    |
| quantity   | Integer   | 数量    |
| shipMethod   | byte   | 寄送方式    |
| payMethod   | byte   | 支付方式    |
| unitRewardPoints   | Integer   | 单个积分    |
| invoicePrice   | double   | 发票价格    |




## 2.2 创建订单

URL: /order/create  
Method：POST  


ResponseBody:  
```json
{
    
    "customerId": 2,
    "starts": 0,
    "totalPrice": 9999.99,
    "createTime": 1582538621800,
    "defaultAddressId": 1,
    "updateTime": 1582538621800,
    "invoiceAddress": "XXX省XXX市XXX县",
    "shipAddress": "XXX省XXX市XXX县",
    "shipPrice": 11.11,
    "orderProducts": "",
    "productId": 1,
    "productCode": "0101010101",
    "productName": "product001",
    "unitPrice": 99.99,
    "quantity": 100,
    "shipMethod": 1,
    "payMethod": 1,
    "unitRewardPoints": 10,
    "invoicePrice": 99.99
    
}

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户名称    |
| starts   | byte   | 状态    |
| createTime   | Long   | 创建时间    |
| defaultAddressId   | Integer   | 默认地址Id    |
| updateTime   | Long   | 修改时间    |
| invoiceAddress   | String   | 发票地址    |
| shipAddress   | String   | 寄送地址    |
| shipPrice   | double   | 运费    |
| orderProducts   | text   | 商品订单    |
| productId   | Integer   | 商品Id    |
| productCode   | String   | 商品代码    |
| productName   | String   | 商品名称    |
| unitPrice   | double   | 单价    |
| quantity   | Integer   | 数量    |
| shipMethod   | byte   | 寄送方式    |
| payMethod   | byte   | 支付方式    |
| unitRewardPoints   | Integer   | 单个积分    |
| invoicePrice   | double   | 发票价格    |


## 2.3 获取订单

URL: /order/getorder?orderId={orderId}
Method：GET  


ResponseBody:  
```json
{
    "customerId": 2,
    "starts": 0,
    "totalPrice": 9999.99,
    "createTime": 1582538621800,
    "defaultAddressId": 1,
    "updateTime": 1582538621800,
    "invoiceAddress": "XXX省XXX市XXX县",
    "shipAddress": "XXX省XXX市XXX县",
    "shipPrice": 11.11,
    "orderProducts": "",
    "productId": 1,
    "productCode": "0101010101",
    "productName": "product001",
    "unitPrice": 99.99,
    "quantity": 100,
    "shipMethod": 1,
    "payMethod": 1,
    "unitRewardPoints": 10,
    "invoicePrice": 99.99
    
}

```

Request Header  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderId   | Integer   | 订单Id    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户名称    |
| starts   | byte   | 状态    |
| createTime   | Long   | 创建时间    |
| defaultAddressId   | Integer   | 默认地址Id    |
| updateTime   | Long   | 修改时间    |
| invoiceAddress   | String   | 发票地址    |
| shipAddress   | String   | 寄送地址    |
| shipPrice   | double   | 运费    |
| orderProducts   | text   | 商品订单    |
| productId   | Integer   | 商品Id    |
| productCode   | String   | 商品代码    |
| productName   | String   | 商品名称    |
| unitPrice   | double   | 单价    |
| quantity   | Integer   | 数量    |
| shipMethod   | byte   | 寄送方式    |
| payMethod   | byte   | 支付方式    |
| unitRewardPoints   | Integer   | 单个积分    |
| invoicePrice   | double   | 发票价格    |

## 2.4 更新订单

URL: /order/updateOrder
Method：POST  

RequestHeader:  
{
    "orderId":1234 
}


ResponseBody:  
```json
{
    
    "customerId": 2,
    "starts": 0,
    "totalPrice": 9999.99,
    "createTime": 1582538621800,
    "defaultAddressId": 1,
    "updateTime": 1582538621800,
    "invoiceAddress": "XXX省XXX市XXX县",
    "shipAddress": "XXX省XXX市XXX县",
    "shipPrice": 11.11,
    "orderProducts": "",
    "productId": 1,
    "productCode": "0101010101",
    "productName": "product001",
    "unitPrice": 99.99,
    "quantity": 100,
    "shipMethod": 1,
    "payMethod": 1,
    "unitRewardPoints": 10,
    "invoicePrice": 99.99
    
}

```

Request Header  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderId   | Integer   | 订单Id    |



Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| customerId   | Integer   | 客户名称    |
| starts   | byte   | 状态    |
| createTime   | Long   | 创建时间    |
| defaultAddressId   | Integer   | 默认地址Id    |
| updateTime   | Long   | 修改时间    |
| invoiceAddress   | String   | 发票地址    |
| shipAddress   | String   | 寄送地址    |
| shipPrice   | double   | 运费    |
| orderProducts   | text   | 商品订单    |
| productId   | Integer   | 商品Id    |
| productCode   | String   | 商品代码    |
| productName   | String   | 商品名称    |
| unitPrice   | double   | 单价    |
| quantity   | Integer   | 数量    |
| shipMethod   | byte   | 寄送方式    |
| payMethod   | byte   | 支付方式    |
| unitRewardPoints   | Integer   | 单个积分    |
| invoicePrice   | double   | 发票价格    |
