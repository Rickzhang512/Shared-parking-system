// pages/community/notice/notice.js
var app = getApp()
var Parser = require('../../../lib/dom-parser')
Page({
  data:{
    userInfo: {}, 
    messages:{},
  },
  onLoad:function(){
    var that = this
    console.log(app.getHeader()+'/getAllMessage')
    wx.request({
      url: app.getHeader()+'/getAllMessage',
      method: 'GET',
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      success: function (res) {
        that.setData({
          list: res.data,
          gl: app.getHeader() +'/img'
        })
      },
      fail() {
        console.log('xxsad')
      }
    })
  },
  onReady:function(){
    // 页面渲染完成
  },
  onShow:function(){
    // 页面显示
  },
  onHide:function(){
    // 页面隐藏
  },
  onUnload:function(){
    // 页面关闭
  },

})