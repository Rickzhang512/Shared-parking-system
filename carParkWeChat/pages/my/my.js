//my.js
var app = getApp();
Page({
  data:{
    username:'未登录',
    money:0
  },
  onShow:function(){
    console.log('onLoad')
    console.log("uid:" + app.globalData.uid)
    var that = this
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      console.log(userInfo);
      //更新数据
      that.setData({
        userInfo:userInfo
      })
    })
    wx.request({
      url: app.getHeader()+'/findUserByUid',
      method: 'POST',
	        data: {
          uid: app.globalData.uid
      },
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      success: function (res) {
        console.log(res);
        console.log(res.data);
        that.setData({
          username: res.data.name,
        })
      },
      fail() {
        console.log('获取错误')
      }
    })
  }
})