# Server API

127.0.0.1:8080/realData

* ### Login 

`
POST /sys/login
`
```
{
    "username": "admin",
    "password": "admin",
    "uuid": "uuid",
    "captcha": "captcha"
}
```
```  
{
    "msg": "success",
    "code": 200,
    "expire": 43200,
    "token": "c7dbb1eab7527907ed7c83b6c330f245"
}
```

* ### Logout 

`
POST /sys/logout
`
```
Content-Type:application/x-www-form-urlencoded
token:99827503703a72f768c4e2b096185175
```