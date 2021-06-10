var app = getApp()
var uid;
Page({
  data: {
  
  },
  onLoad: function () {
    var that = this
    console.log('notices.js----->openid:' + app.globalData.openid)
    uid = app.globalData.uid
    console.log("uid:" + app.globalData.uid)
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else {
      wx.request({
        url: app.getHeader() + '/getAllRent',
        method: 'POST',
        header: {
          'content-type': 'application/x-www-form-urlencoded;charset=utf-8'//
        },
        data: {},
        success: function (res) {
          that.setData({
            list: res.data
          })
        },
        fail() {
          console.log('出错啦')
        }
      })
    }
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
  addButton: function (e) {
    console.log(e);
    var that = this;
    console.log( e.currentTarget.dataset.id)
    var uid = app.globalData.uid
    console.log("uid:" + uid)
    if (!app.globalData.uid) {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    } else {
    wx.request({
      url: app.getHeader() + '/insertOrder',
      method: 'POST',
      /*header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8'//
      },*/
      data: { "rentId": e.currentTarget.dataset.id,"uid":uid},
      success: function (res) {
        console.log(res);
        if (res.data != "failure") {
          wx.showToast({
            title: '预约成功',
            icon: 'success',
            duration: 2000
          })
        } else {
          wx.showToast({
            title: '预约失败',
            duration: 1000,
            icon: 'none'
          })
        }
       
      },
      fail() {
        console.log('xxsad')
      }
    })
  }
  },
})