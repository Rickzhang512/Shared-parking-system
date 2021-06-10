var app = getApp();
Page({
  data: {
    // tab 切换
    tabArr: {
      curHdIndex: 1,
      curBdIndex: 1,
      defaultType: true,
      passwordType: true,
      
    }
    
  },
   //defaultType：眼睛状态   passwordType：密码可见与否状态
   eyeStatus: function() {
    if (this.data.defaultType) {
      this.setData({
        passwordType: false,
        defaultType: false,
      })
    } else {
      this.setData({
        passwordType: true,
        defaultType: true,
      })
    }
  },
  onLoad: function () {
    // 页面初始化 options为页面跳转所带来的参数
    console.log('onLoad');

  },
  RegisterInfo: function (e) {
    console.log(e.detail.value);
    var json = JSON.stringify(e.detail.value)
    console.log("RegisterInfojson:" + json)
    console.log("url:" + app.getHeader() + '/RegisterUser')
    wx.request({
      url: app.getHeader() + '/registerUser', // 拼接接口地址
      method: 'post',
      data: json,
      contentType: 'application/json',
      success(res) {
        console.log('res:' + res)
        if (res.data == "success") {
          wx.showToast({
            title: '注册成功',
            icon: 'success',
            duration: 2000
          })
         
        } else {
          wx.showToast({
            title: '注册失败',
            duration: 1000,
            icon: 'none'
          })
          
        }
      }
    })
  },
  UserLogin:function(e){
    var json = JSON.stringify(e.detail.value)
    console.log("userlogin:" + json)
    wx.request({
      url: app.getHeader() + '/userLogin', // 拼接接口地址
      method: 'post',
      data: json,
      contentType: 'application/json',
      success(res) {
        console.log('res.data:' + res.data)
        app.globalData.uid = res.data
        if (res.data != "failure") {
          wx.showToast({
            title: '登录成功',
            icon: 'success',
            duration: 2000
          }),
            wx.switchTab({
              url: '../index/index',
            })
            // setTimeout(function () {
            //   wx.navigateBack({
            //     delta: 2
            //   })
            // }, 1000)
        } else {
          wx.showToast({
            title: '登录失败',
            duration: 1000,
            icon: 'none'
          })
        }
      }
    })
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  //tab切换
  tab: function (e) {
    //var dataId = e.currentTarget.dataset.id;
    var dataId = e.currentTarget.id;
    var obj = {};
    obj.curHdIndex = dataId;
    obj.curBdIndex = dataId;
    this.setData({
      tabArr: obj
    })
    console.log(obj);
  },
  showok: function () {
    wx.showToast({
      title: '信息提交成功',
      icon: 'success',
      duration: 2000
    })
  }
})



