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
| productId   | String   | 商品名称    |
| price   | String   | 价格    |
| storkQuantity   | String   | 库存   |
| status   | integer   | 状态    |
| pageNum   | integer   | 页码    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| interviewId   | Integer   | 面试Id    |
| productName   | String   | 公司名    |
| productCode   | String   | 学生Id    |
| price   | String   | 面试学生    |
| discount   | Long   | 面试时间, 按照时间降序    |
| storkQuantity   | byte   | 面试状态    |
| status   | byte   | 面试状态    |
| sortOrder   | byte   | 面试状态    |
| rewardPoints   | byte   | 面试状态    |
| mainPicUrl   | byte   | 面试状态    |
| productAbstract   | byte   | 面试状态    |
| total   | byte   | 面试状态    |
| pageSize   | byte   | 面试状态    |
| pageNum   | byte   | 面试状态    |


