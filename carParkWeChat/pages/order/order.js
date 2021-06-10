var app = getApp()
var uid=""
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:[],
    currentStatus:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
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
        url: app.getHeader() + '/getOrderByUid',
        method: 'POST',
        header: {
          'content-type': 'application/x-www-form-urlencoded;charset=utf-8'//
        },
        data: { "uid": app.globalData.uid},
        success: function (res) {
          console.log(res.data)
          that.setData({
            list: res.data
          })
        },
        fail() {
          console.log('xxsad')
        }
      })
    }
  },
  
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  // /**
  //  * 生命周期函数--监听页面隐藏
  //  */
  // onHide: function () {
    
  // },

  // /**
  //  * 生命周期函数--监听页面卸载
  //  */
  // onUnload: function () {
    
  // },

  // /**
  //  * 页面相关事件处理函数--监听用户下拉动作
  //  */
  // onPullDownRefresh: function () {
    
  // },

  // /**
  //  * 页面上拉触底事件的处理函数
  //  */
  // onReachBottom: function () {
    
  // },

})