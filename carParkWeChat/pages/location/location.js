var app = getApp()
let logs=[1,4]
Page({
  data: {
    id1: "1",
    id2: "2",
    id3: "3",
    id4: "4",
    id5: "5",
    id6: "6",
    id7: "7",
    id8: "8",
    id9: "9",
    id10: "10",
    id11: "11",
    id12: "12",
    id13: "13",
    id14: "14",
    id15: "15",
    id16: "16",
    id17: "17",
    id18: "18",
    id19: "19",
    id20: "20",
    id21: "21",
    id22: "22",
    id23: "23",
    id24: "24",
    id25: "25",
    id26: "26",
    id27: "27",
    id28: "28",
    id29: "29",
    id30: "30",
    select:"0",
    num:"0",
    screenData: "",
    lastIsOperator: false,
    locationData:"没有数据",
    logs: [],
    selected:[],
    boolArry:[],
    onSelected:[],
    id:"",
    sheny:"0",
  },
  getQueryString: function(url) {
    var reg = new RegExp("(^|&)" + url + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
  },
  //事件处理函数 
  onLoad: function (options) {
    console.log(options);
    var that = this;
    wx.request({
      url: app.getHeader()+'/getParkById',
      method: 'get',
      data: {"id":options.id},
      contentType: 'application/json',
      success: function (res) {
        console.log(res.data);
        /**that.setData({
          list: res.data,
        })**/
        console.log(res.data.parkNumber/4)
        console.log(27/4)
        console.log(parseInt(29/4))
        let selectArray=undefined==res.data.userInfo?[]:res.data.userInfo.split(",");
        let tt = selectArray.map(Number);
        let boolArry = new Array();
        console.log(tt.indexOf(1)>-1);
        for(var i = 0;i<res.data.parkNumber;i++){
          let flag = i+1;
          if (tt.indexOf(flag)>-1){
            boolArry.push(true);
          } else {
            boolArry.push(false);
          }
        }
        that.setData({
          id: res.data.id,
          screenData: res.data.parkName,
          num: parseInt(res.data.parkNumber/4),
          sheny: res.data.parkNumber%4==0?0:res.data.parkNumber%4,
          selected: tt,
          boolArry: boolArry,
        })
        console.log(undefined==res.data.userInfo?[]:res.data.userInfo.split(","))
        
      },
      fail() {
        console.log('获取错误')
      }
    })
    this.setData({
      id: options.id
    })
  },
  onReady: function () { },
  onShow: function () { },
  onHide: function () { },
  onUpload: function () { },

  clickButton: function (event) {
    var id = event.target.id;
    console.log(id);
    console.log(event);
    console.log(this.data);
    var that = this;
    console.log(that.data.onSelected)
    console.log(that.data.onSelected.indexOf(parseInt(id))>-1)
    if (that.data.selected.indexOf(parseInt(id))>-1 || that.data.onSelected.indexOf(id)>-1){
      wx.showModal({
        title: '错误提示',
        content: '该车位已被占用,请另选',
        success: function(res) {
        if (res.confirm) {
          
        } else if (res.cancel) {
          console.log('用户点击取消')
        }
      }
      })
      return;
    }
    
    wx.showModal({
      title: '提示',
      content: '是否确定预约车位',
      success: function(res) {
      if (res.confirm) {
        that.data.boolArry[id-1]=true;
        that.data.onSelected.push(id);
        that.setData({
          boolArry: that.data.boolArry,
          onSelected: that.data.onSelected,
        })
      } else if (res.cancel) {
        console.log('用户点击取消')
      }
      }
      })
    
    /**this.setData({
      locationData: id,
      select: id,
      num:id,
    })**/
    /**if (select =='0') {
      this.setData({
        locationData: id,
        select:"1"
      })
    } else {
      this.setData({
        locationData: id,
        select: "0"
      })
    }*/
  },
  
  addButton: function (e) {
    console.log(e);
    var that = this;
    console.log( e.currentTarget.dataset.id)
    console.log( e.currentTarget.dataset.loca)
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
      url: app.getHeader() + '/updateParkInfoById',
      method: 'post',
        header: {
          'content-type': 'application/x-www-form-urlencoded;charset=utf-8'//
        },
      data: { "id": e.currentTarget.dataset.id,"loca": e.currentTarget.dataset.loca,"isOk":0,"uid":uid},
      success: function (res) {
        console.log(res);
        if(res.data=="ok"){
          wx.showToast({
            title: '停车成功',
            icon: 'success',
            duration: 2000
          })
        } else {
          wx.showToast({
            title: '停车失败',
            icon: 'fail',
            duration: 2000
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