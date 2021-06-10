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
    duration: 1000,
    inputValue:''
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onShow: function () {
    var that = this;
    wx.request({
      url: app.getHeader()+'/getAllPark',
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
  inputBind: function(event) {
    this.setData({
        inputValue: event.detail.value
    })
    console.log('bindInput' + this.data.inputValue)

  },
  suo: function(event) {
       var that = this

        /**
         * keyword string 搜索关键词 ; 这里是 this.data.inputValue
         * start int 分页起始值 ; 这里是 0
         */
        wx.request({
			      url: app.getHeader()+'/getParkByParkName',
            data: {
                parkName: this.data.inputValue
            },
            method: 'GET',
            success: function(res1) {
                // console.log(res1.data)
                // console.log(res1.data.parkName)
                if (!that.data.inputValue) {
                  //没有搜索词 友情提示
                  wx.showToast({
                      title: '请重新输入',
                      duration: 2000,
                  })
				        } else if (res1.data==null) {
                  //搜索词不存在 友情提示
                  wx.showToast({
                      title: '关键词不存在',
                      duration: 2000,
                  })
				        }else{
                  var a=[{feeScale: res1.data.feeScale, parkLocation: res1.data.parkLocation, parkName: res1.data.parkName, parkNumber: res1.data.parkNumber}]
                  // var searchData = res.data
                  that.setData({
                     list:a
                })

            }
            },
            
            fail() {
              console.log('获取错误')
            }
            
        })
        
	
}
})

