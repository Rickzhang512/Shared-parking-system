var app = getApp()
var Parser = require('../../../../lib/dom-parser')
Page({
  data:{
  },
  onLoad:function(options){
    
    var that = this
    var content = options.title;
    console.log("=======>10"+options.title);
    var url = app.getHeader() + '/word';
    wx.request({
      url: url, // 拼接接口地址
      method: 'GET',
      header: {
        'content-type': 'application/json;charset=UTF-8' // 默认值
      },
      data:{"content":content},
      success(res) {
        if (res) {
          var xml = res.data
          console.log("img:"+options.img)
          that.setData({
            res: res,
            time: options.time,
            author: options.author,
            title: options.title,
            content: options.content,
            img: app.getHeader() +'/upload/'+options.img
          })
        } else {
          console.log('没有数据')
        }
      },
      fail(){
        console.log('失败')
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