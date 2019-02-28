# 通讯API

## enum code
* UNKNOWN_ERROR(-1,"未知错误"),
* DEVICE_REGISTER(99, "注册"),
* REGISTER_SUCCESS(100, "开机注册成功"),
* VERSION_REQUEST(101, "请求版本号"),
* VERSION_REQUEST_SUCCESS(102, "版本号请求成功"),
* DATA_FORMAT_ERROR(-2,"数据格式错误"),
* OPERATION_READY(151,"准备要开始新的手术，获取operationNumber"),
* OPERATION_READY_SUCCESS(152,"服务器准备完毕，可以开始手术了"),
* OPERATION_DEVICE_READY(153,"准备开始发送手术设备信息"),
* OPERATION_DEVICE_READY_SUCCESS(154,"可以准备开始发送手术设备信息"),
* OPERATION_DEVICE(155,"是手术设备信息"),
* OPERATION_DEVICE_SUCCESS(156,"该条信息保存完毕"),
* OPERATION_DEVICE_END(157, "设备数据发送完毕"),
* OPERATION_DEVICE_END_SUCCESS(158, "回复设备数据发送可以完毕"),
* PATIENT_INFO_READY(159,"准备上传病人数据"),
* PATIENT_INFO_READY_SUCCESS(160, "可以开始上传病人数据"),
* PATIENT_INFO(161,"是病人数据"),
* PATIENT_INFO_SUCCESS(162, "该条病人数据保存完毕"),
* PATIENT_INFO_END(163,"病人信息发送完毕"),
* PATIENT_INFO_END_SUCCESS(164,"病人信息发送完毕收到"),
* DEVICE_DATA_READY(165, "准备发送仪器数据"),
* DEVICE_DATA_READY_SUCCESS(166, "可以开始上传仪器数据"),
* DEVICE_DATA(167, "是仪器数据"),
* DEVICE_DATA_SUCCESS(168, "该条仪器数据保存完毕"),
* DEVICE_DATA_END(169,"仪器数据发送完毕"),
* DEVICE_DATA_END_SUCCESS(170,"病人信息发送完毕收到"),
* OPERATION_MARK_READY(171,"手术过程中标记信息准备发送"),
* OPERATION_MARK_READY_SUCCESS(172,"手术过程中标记信息可以发送"),
* OPERATION_MARK(173,"是手术过程中的标记数据"),
* OPERATION_MARK_SUCCESS(174,"该条过程中的标记数据收到"),
* OPERATION_MARK_END(175, "手术过程中的标记数据发送结束"),
* OPERATION_MARK_END_SUCCESS(176, "手术过程中的标记数据发送结束收到"),
* OPERATION_END_READY(177,"请求手术结束"),
* OPERATION_END_READY_SUCCESS(178, "是手术结束的信息"),
* OPERATION_END(179, "是手术结束的信息"),
* OPERATION_END_SUCCESS(180, "回复收到手术结束的信息"),
* POSTOPERATIVE_PATIENT_INFO_READY(181, 请求发送术后患者信息),
* POSTOPERATIVE_PATIENT_INFO_READY_SUCCESS(182, "可以发送术后患者信息，服务器已经准备好了"),
* POSTOPERATIVE_PATIENT_INFO(183, "是术后患者信息"),
* POSTOPERATIVE_PATIENT_INFO_SUCCESS(184, "收到术后患者信息"),
* FEEDBACK_INFO(185, "是反馈数据"),
* FEEDBACK_INFO_SUCCESS(186, "反馈数据接收成功"),


## 上传规则
### 1. 所有设备开机时发送
* 数据上传URL 120.79.151.208:8080/campephilus/instrument/
* 请求方式 POST
* 请求类型 x-www-form-urlencoded
* 请求体
```
code: 199
mac: "mac"
operationNumber: 1
data: {}
```
code、mac、operationNumber、data为必填字段


* #### 设备开机注册(未使用)
```
code: 99
mac: "mac"
operationNumber: -1
data: {}
```

* #### 服务器将回复(未使用)
```
code: 100
mac: "mac"
operationNumber: -1
data: {}
```

* #### 请求版本号
```
code: 101
mac: "mac"
operationNumber: -1
data: {}
```

* #### 回复请求版本号
```
code: 102
mac: "mac"
operationNumber: -1
data: {
      	"applicationVersion": "0.1.0",
      	"collectorVersion": "0.1.0"
      }
```

* #### 准备要开始手术了(手术开始准备,请求operationNumber)
```
code: 151
mac: "mac"
operationNumber: -1
data:{
     	"operationInfo": {
     	    "patientId": "patientId",
     		"operationHospitalCode": "0147",
     		"operationStartTime": "1546501804000"
     	},
     	"deviceInfo": [{
     		"deviceType": 1,
     		"serialNumber": "SN123123",
     		"serviceLife": 2
     	}, {
     		"deviceType": 2,
     		"serialNumber": "SN1231233",
     		"serviceLife": 3
     	}]
     }
```

* #### 服务器也准备完毕，返回operationNumber，可以上传了
```
code: 152
mac: "mac"
operationNumber: 1
data: {}
```

*** #### 准备发送手术设备数据
```
code: 153
mac: "mac"
operationNumber: 1
data: {}
```

*** #### 回复可以发送发送手术设备数据
```
code: 154
mac: "mac"
operationNumber: 1
data: {}
```

* #### 准备发送病人信息数据
```
code: 159
mac: "mac"
operationNumber: 1
data: {}
```

* #### 可以上传病人数据数据
```
code: 160
mac: "mac"
operationNumber: 1
data: {}
```

* #### 上传病人数据
```
code: 161
mac: "mac"
operationNumber: 1
data: {
      	"patientId": "value",
      	"patientData": {},
      	"preoperativeData": {}
      }
```
* #### 接收到该条病人数据
```
code: 162
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发布病人信息发送结束
```
code: 163
mac: "mac"
operationNumber: 1
data: {}
```

* #### 回复收到病人信息发送结束
```
code: 164
mac: "mac"
operationNumber: 1
data: {}
```

* #### 准备发送仪器数据
```
code: 165
mac: "mac"
operationNumber: 1
data: {}
```

* #### 可以发送仪器数据
```
code: 166
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送仪器数据
```
code: 167
mac: "mac"
operationNumber: 1
data: {
      	"deviceId": "value",
      	"deviceDataNumber": "",
      	"deviceData": {}
      }
```

* #### 接收到该条数据
```
code: 168
mac: "mac"
operationNumber: 1
data: {}
```

* #### 仪器数据发送结束
```
code: 169
mac: "mac"
operationNumber: 1
data: {}
```

* #### 回复收到医疗仪器数据结束信号
```
code: 170
mac: "mac"
operationNumber: 1
data: {}
```

* #### 手术中的标记信息准备发送
```
code: 171
mac: "mac"
operationNumber: 1
data: {}
```

* #### 手术中的标记信息可以发送
```
code: 172
mac: "mac"
operationNumber: 1
data: {}
```

* #### 手术中的标记信息
```
code: 173
mac: "mac"
operationNumber: 1
data: {
      	"markNumber": 1,
      	"markType": 1,
        "markTime": "1546501804000",
      	"markMessage": {}
      }
```

* #### 收到该条标记信息
```
code: 174
mac: "mac"
operationNumber: 1
data: {}
```

* #### 手术标记信息发送完毕
```
code: 175
mac: "mac"
operationNumber: 1
data: {}
```

* #### 手术标记信息发送完毕收到
```
code: 176
mac: "mac"
operationNumber: 1
data: {}
```

* #### 请求手术结束
```
code: 177
mac: "mac"
operationNumber: 1
data: {}
```

* #### 回复手术可以结束
```
code: 178
mac: "mac"
operationNumber: 1
data: {}
```

* #### 是手术结束的信息
```
code: 179
mac: "mac"
operationNumber: 1
data: {
      	"operationEndTime": ""
      }
```

* #### 回复收到手术结束的信息
```
code: 180
mac: "mac"
operationNumber: 1
data: {}
```

* #### 请求发送术后患者情况(平板记录下来operationNumber)
```
code: 181
mac: "mac"
operationNumber: 1
data: {}
```

* #### 可以发送术后患者情况(平板记录下来operationNumber)
```
code: 182
mac: "mac"
operationNumber: 1
data: {}
```

* #### 请求发送术后患者情况
```
code: 183
mac: "mac"
operationNumber: 1
data: {
          "patientId": "value",
          "postoperativeData": {}
      }
```

* #### 收到发送的术后患者情况
```
code: 184 
mac: "mac"
operationNumber: 1
data: {}
```

* #### 发送用户反馈信息
```
code: 185
mac: "mac"
operationNumber: 1
data: {
          "msg": "使用极其困难,投诉"
      }
```

* #### 收到发送的用户反馈信息
```
code: 186
mac: "mac"
operationNumber: 1
data: {}
```