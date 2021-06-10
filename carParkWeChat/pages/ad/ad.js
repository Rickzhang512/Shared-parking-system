//获取应用实例
var app = getApp()
Page({ 
  data: {
    imgUrls: [
      '../../images/slider_1.jpeg',
      '../../images/slider_2.jpeg',
      '../../images/slider_3.jpeg'
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 1000
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    var that = this;
    wx.request({
      url: app.getHeader()+'/getAllMessage',
      method: 'GET',
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      success: function (res) {
        console.log(res);
        that.setData({
          list: res.data,
          //gl: app.getHeader() +'/img'
        })
      },
      fail() {
        console.log('获取错误')
      }
    })
  },
  tapName: function(event) {
    console.log(event)
  }
})

