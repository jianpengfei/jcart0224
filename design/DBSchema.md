# Administrator
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| administrator_id  | int  | 主键 自增 | Id  |
| username | varchar(20)  | 非空，唯一索引 | 用户名  |
| real_name  | varchar(20)  | 索引 | 真实姓名  |
| email  | varchar(100)  | 索引 | 邮箱  |
| encrypted_password  | varchar(100)  | 非空 | 加密密码  |
| status  | tinyint  | 非空，默认启用  | 状态（0禁用，1启用）  |
| create_time  | datetime  |  非空 | 创建时间  |
| avatar_url  | varchar(100)  |   | 头像地址 |


# Product
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| product_id  | int  | 主键 自增 | Id  |
| product_name| varchar(100)  | 非空 | 商品名称  |
| product_code | varchar(50)  | 非空，唯一索引 | 商品代码  |
| price| double  | 非空 | 商品价格  |
| discount| double  |  | 打折  |
| stork_quantity| int  | 非空,默认0 | 商品库存量  |
| starts| tinyint  | 非空 | 状态(0下架、1上架、2待审核) |
| sort_order| int  |  | 商品排序(0正序、1倒序)  |
| reward_points| int  |  | 商品积分  |
| main_pic_url| varchar(100)  | 非空 | 商品主图  |
| product_abstract| varchar(300)  | 非空 | 商品摘要  |


# ProductDetai
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| product_id  | int  | 外键 | 商品Id  |
| product_description| varchar(300)  | 非空 | 商品描述 |
| other_pic_url| varchar(300)  | 非空 | 商品附图  |


# Order
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_id  | int  | 主键 自增 | Id  |
| customer_id  | int  | 非空,索引,外键 | 客户Id  |
| starts| tinyint  | 非空 | 订单状态(0待审核、1处理中、2待发货、3已发货、4待签收、5已签收、6待支付、7已支付、8取消、9拒绝、10完成) |
| total_price| double  | 非空 | 订单总金额  |
| create_time| datetime  | 非空 | 创建时间  |
| update_time| datetime  | 非空 | 修改时间  |
| ship_method| smallint  | 非空 | 寄送方式  |
| pay_method| smallint  | 非空 | 支付方式  |
| reward_points| int  |  | 订单积分  |


# OrdertDetai
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_id  | int  | 外键 | 订单Id  |
| invoice_address| varchar(300)  | 非空 | 发票地址 |
| ship_address| varchar(300)  | 非空 | 寄送地址  |
| ship_price| double  | 非空 | 运费  |
| order_products| varchar(300)  | 非空 | 订单商品  |
| product_id  | int  | 外键 | 商品Id  |
| product_code | varchar(50)  | 非空 | 商品代码  |
| product_name| varchar(100)  | 非空 | 商品名称  |
| unit_price| double  | 非空 | 单价  |
| quantity| int  | 非空 | 数量  |


# OrderHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| order_id  | int  | 外键 | 订单Id  |
| order_history_id  | int  | 主键 自增 | 订单历史Id  |
| time| datetime  | 非空 | 时间  |
| comment| varchar(300)  |  | 备注  |
| starts| tinyint  | 非空 | 订单状态 |
| customer_notified| bit  | 非空 | 是否通知用户  |


# Customer
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| customer_id  | int  | 主键 自增 | Id  |
| username | varchar(20)  | 非空 | 用户名  |
| real_name  | varchar(20)  | 非空 | 真实姓名  |
| encrypted_password  | varchar(100)  | 非空 | 加密密码  |
| news_subscribed| bit  | 非空 | 是否订阅新闻  |
| default_address_id  | int  | 外键 | 默认地址Id  |
| email  | varchar(100)  | 索引 | 邮箱  |
| email_verified| bit  | 非空 | 邮箱验证  |
| mobile  | varchar(100)  | 索引 | 手机  |
| mobile_verified| bit  | 非空 | 手机验证  |

# Address
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| customer_id  | int  | 外键 | 客户Id  |
| address_id  | int  | 主键 自增 | 地址Id  |
| receiver_name  | varchar(20)  | 非空 | 收货人姓名  |
| receiver_mobile  | varchar(100)  | 索引 | 收货电话  |
| content  | varchar(300)  | 非空 | 地址内容  |
| address_name  | varchar(300)  | 非空 | 地址名称  |


# Returns
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| returns_id  | int  | 主键 自增 | Id  |
| customer_name| varchar(100)  | 非空 | 商品名称  |
| email  | varchar(100)  | 索引 | 邮箱  |
| mobile  | varchar(100)  | 索引 | 手机  |
| order_id  | int  | 外键 | 订单Id  |
| order_time| datetime  | 非空 | 订单时间  |
| product_name| varchar(100)  | 非空 | 商品名称  |
| product_code | varchar(50)  | 非空，唯一索引 | 商品代码  |
| quantity| int  | 非空 | 数量  |
| reason| varchar(300)  |  | 理由  |
| opened| bit  | 非空 | 是否开封  |
| comment| varchar(300)  |  | 备注  |
| action  | tinyint  | 非空  | 处理方式（0退货，1换货、2修理）  |

# ReturnHistory
| 字段  | 类型  | 约束  |  说明 |
|---|---|---|---|
| return_id  | int  | 外键 | 订单Id  |
| return_history_id  | int  | 主键 自增 | 退货历史Id  |
| time| datetime  | 非空 | 时间  |
| comment| varchar(300)  |  | 备注  |
| return_status| tinyint  | 非空 | 退货状态 |
| customer_notified| bit  | 非空 | 是否通知用户  |