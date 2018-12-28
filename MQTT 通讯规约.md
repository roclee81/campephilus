# 通讯API

## enum code
* UNKNOWN_ERROR(-1,"未知错误"),
* DEVICE_REGISTER(199, "注册"),
* REGISTER_SUCCESS(200, "开机注册成功"),

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

## Topic规则
* 采集器设备信息上传
```
Topic:/medical/sys/E0D55E227B92/event/update
```
* 患者信息上传
```
Topic:/medical/data/E0D55E227B92/patient/post
```
* 仪器输出信息上传
```
Topic:/medical/data/E0D55E227B92/device/post
```
* 手术标记信息上传
```
Topic:/medical/data/E0D55E227B92/operation/mark/post
```

## 发布规则
### 1. 所有设备开机时在公共`Topic:`发布自己的机器`Topic`
```
{
    "code": 199,
    "msg": {
        "mac": "mac",
    }
}
```
### 2. 服务器将会在公共`Topic`,上回复
```
{
    "code": 200,
    "msg": {
        "mac": "mac",
    }
}
```
### 3. 服务器订阅上述4个Topic


* #### 准备要数据(手术开始准备,请求operationNumber)上传了`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 151,
    "msg": {
        "mac": "mac",
        "operationNumber": "0",     
        "data":{
            "patientId": "patientId"
        }
    }
}
```

* #### 服务器也准备完毕，返回operationNumber，可以上传了`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 152
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 准备发送手术设备数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 153,
    "msg": {
        "mac": "mac",
        "operationNumber": "1",
        }
    }
}
```

* #### 回复可以发送发送手术设备数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 154,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
        }
    }
}
```

* #### 发送手术设备数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
	"code": 155,
	"msg": {
		"mac": "mac",
		"operationNumber": "1",
		"data": {
			"hospitalCode": "0147",
			"deviceInformation": {}
		}
	}
}
```

* #### 接收到该条设备数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 156,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 设备数据发送完毕`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 157,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 回复设备数据发送可以完毕`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 158,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```


* #### 准备发送病人信息数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 159,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 可以上传病人数据数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 160,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 上传病人数据`Topic:medical/data/E0D55E227B92/patient/post`
```
{
	"code": 161,
	"msg": {
		"mac": "mac",
		"operationNumber": "1",
		"data": {
			"patientId": "value",
			"patientData": "value"
		}
	}
}
```
* #### 接收到该条病人数据`Topic:medical/data/E0D55E227B92/patient/post`
```
{
    "code": 162,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 发布病人信息发送结束`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 163,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 回复收到病人信息发送结束`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 164,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 准备发送仪器数`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 165,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 可以发送仪器数据`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 166,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 发送仪器数据`Topic:/medical/data/E0D55E227B92/device/post`
```
{
    "code": 167,
    "msg": {
        "mac": "mac",
        "operationNumber": "1",
        "data": {
            "deviceId": "value",
            "deviceDataNumber": "",
            "deviceData": {
            }
        }
    }
}
```

* #### 接收到该条数据`Topic:/medical/data/E0D55E227B92/device/post`
```
{
    "code": 168,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 仪器数据发送结束`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 169,
    "msg": {  
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 回复收到医疗仪器数据结束信号`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 170,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 手术中的标记信息准备发送`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 171,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 手术中的标记信息可以发送`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 172,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 手术中的标记信息`Topic:/medical/data/E0D55E227B92/operation/mark/post`
```
{
	"code": 173,
	"msg": {
		"mac": "mac",
		"operationNumber": "1",
		"data": {
			"markNumber": 1,
			"markType": 1,
			"markMessage": {}
		}
	}
}
```

* #### 收到该条标记信息`Topic:/medical/data/E0D55E227B92/operation/mark/post`
```
{
    "code": 174,
    "msg": {
        "mac": "mac",
        "operationNumber": "1",
    }
}
```

* #### 手术标记信息发送完毕`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 175,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```

* #### 手术标记信息发送完毕收到`Topic:/medical/sys/E0D55E227B92/event/update`
```
{
    "code": 176,
    "msg": {
        "mac": "mac",
        "operationNumber": "1"
    }
}
```
