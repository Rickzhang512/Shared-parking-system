var app = getApp();
var tempFilePaths;
var uid="";
var total = [];
Page({
  data: {
    // tab 切换
    date1:'',
    date2:'',
    time:"",
  },
  onLoad: function (option) {
    /**var uid = app.globalData.uid
    this.setData({
      uid:uid
    })**/
    console.log("goodsid:"+option.id)
  },
  bindDateChange: function(e){
    console.log(e)
    this.setData({date1:e.detail.value})
  },
  bindDateChange2: function(e){
    console.log(e)
    this.setData({date2:e.detail.value})
  },
  bindTimeChange: function(e){
    console.log(e)
    this.setData({time:e.detail.value})
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
  submitCarInfo:function(e){
    var uid = app.globalData.uid
    console.log("uid:" + uid)
    e.detail.value.imageUrl = tempFilePaths;
    e.detail.value.parkStartTime=this.data.date1;
    e.detail.value.parkEndTime=this.data.date2;
    if (app.globalData.uid == '') {
      wx.showToast({
        title: '请先注册或登录',
        duration: 1000,
        icon: 'none'
      })
    }else{
      console.log(app.globalData.uid);
      console.log(e.detail.value);
      console.log(uid);
      e.detail.value.uid = app.globalData.uid;
      var json = JSON.stringify(e.detail.value)
      console.log(json);
      wx.request({
        url: app.getHeader() + '/insertRent', // 拼接接口地址
        method: 'post',
        data: json,
        contentType: 'application/json',
        success(res) {
          console.log('res.data:' + res.data)
          if (res.data != "failure") {
            wx.showToast({
              title: '信息提交成功',
              icon: 'success',
              duration: 2000
            })
          } else {
            wx.showToast({
              title: '信息提交失败',
              duration: 1000,
              icon: 'none'
            })
          }
        }
      })
    }
  },
  preImage:function(e){
    var that = this;
    var currentImageUrl = that.data.imageUrl[e.target.dataset.index]
    wx.previewImage({
      current: currentImageUrl, // 当前显示图片的http链接
      urls: that.data.imageUrl // 需要预览的图片http链接列表
    })
  },
  chooseImg: function(){
    var that = this;
    wx.chooseImage({
      count: 3, 
      sizeType: ['original', 'compressed'], 
      sourceType: ['album', 'camera'],
      success: function (res) {
        tempFilePaths = res.tempFilePaths
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        that.uploadFile2(tempFilePaths, 0);
        var uploadedImageLists = that.data.imageUrl;
        var totalImages = uploadedImageLists.concat(res.tempFilePaths);
        var aNum = 0;
        if (totalImages.length >= 3) {
          totalImages.length = 3;
          aNum = 1;
        }
        console.log(totalImages)
        that.setData({
          num: 0,
          addNum: aNum,
          imageUrl: totalImages
        })
      }
    })
  },
  uploadFile2: function (file, i) {//递归调用
    var that = this;
    wx.uploadFile({
      url: app.getHeader() +'/uploadWxImg', //仅为
      filePath: file[i],
      name: 'img',
      success: function (res) {
        var obj = new Object();
        console.log(res);
        var data = res.data;
        data = JSON.parse(data);
        console.info(data);
        console.info(data.data);
        obj.src = data;
        console.info("--------------*****-------------------");
        console.info(obj);
        if (!((i + 1) == file.length)) {
          total.push(obj);
          that.uploadFile2(file, i + 1);
        } else {
          total.push(obj);
          that.setData({ perImgSrc: total });
        }
      }
    })
  },
  removeImage: function(e){
    var that = this;
    var currentImageLists = that.data.imageUrl; 
    currentImageLists.splice(e.target.dataset.index,1);
    that.setData({
        imageUrl:currentImageLists
    })
    if(currentImageLists.length < 3 && currentImageLists.length >= 1) {
       that.setData({
            addNum: 0
       })
    } else if(currentImageLists.length == 0) {
       that.setData({
            addNum: 1,
            num: 1
       })
    }
  },
  showok: function () {
    wx.showToast({
      title: '信息提交成功',
      icon: 'success',
      duration: 2000
    })
  }
})



