"use strict";(self["webpackChunkvue3_nb0"]=self["webpackChunkvue3_nb0"]||[]).push([[463],{45463:(e,l,o)=>{o.r(l),o.d(l,{default:()=>k});o(92222),o(57658),o(38862);var n=o(66252),a=o(49963),u=o(2262),t=function(e){return(0,n.dD)("data-v-5d56a896"),e=e(),(0,n.Cn)(),e},i={class:"login_view"},s=t((function(){return(0,n._)("div",{class:"title_view"},"学生竞赛管理系统登录",-1)})),r={key:0,class:"list_item"},v=t((function(){return(0,n._)("div",{class:"list_label"}," 账号： ",-1)})),c={key:1,class:"list_item"},d=t((function(){return(0,n._)("div",{class:"list_label"}," 密码： ",-1)})),f=["onKeydown"],m={key:2,class:"list_type"},p=t((function(){return(0,n._)("div",{class:"list_label"}," 用户类型： ",-1)})),g={class:"btn_view"};const w={__name:"login",setup:function(e){var l,o=(0,u.iH)([]),t=(0,u.iH)([]),w=(0,u.iH)({role:"",username:"",password:""}),_=(0,u.iH)(""),h=(0,u.iH)(1),k=null===(l=(0,n.FN)())||void 0===l?void 0:l.appContext.config.globalProperties,b=function(){if(w.value.username)if(w.value.password){if(o.value.length>1){if(!w.value.role)return null===k||void 0===k||k.$toolUtil.message("请选择角色","error"),void verifySlider.value.reset();for(var e=0;e<t.value.length;e++)t.value[e].roleName==w.value.role&&(_.value=t.value[e].tableName)}else _.value=o.value[0].tableName,w.value.role=o.value[0].roleName;y()}else null===k||void 0===k||k.$toolUtil.message("请输入密码","error");else null===k||void 0===k||k.$toolUtil.message("请输入用户名","error")},y=function(){null===k||void 0===k||k.$http({url:"".concat(_.value,"/login?username=").concat(w.value.username,"&password=").concat(w.value.password),method:"post"}).then((function(e){null===k||void 0===k||k.$toolUtil.storageSet("Token",e.data.token),null===k||void 0===k||k.$toolUtil.storageSet("role",w.value.role),null===k||void 0===k||k.$toolUtil.storageSet("sessionTable",_.value),null===k||void 0===k||k.$toolUtil.storageSet("adminName",w.value.username),null===k||void 0===k||k.$router.push("/")}),(function(e){}))},U=function(){null===k||void 0===k||k.$router.push({name:"forget"})},$=function(){var e={page:1,limit:1,sort:"id"};null===k||void 0===k||k.$http({url:"menu/list",method:"get",params:e}).then((function(e){t.value=JSON.parse(e.data.data.list[0].menujson);for(var l=0;l<t.value.length;l++)"是"==t.value[l].hasBackLogin&&o.value.push(t.value[l]);w.value.role=o.value[0].roleName,null===k||void 0===k||k.$toolUtil.storageSet("menus",JSON.stringify(t.value))}))},N=function(){$()};return(0,n.bv)((function(){N()})),function(e,l){var u=(0,n.up)("el-option"),t=(0,n.up)("el-select"),_=(0,n.up)("el-button"),k=(0,n.up)("el-form"),y=(0,n.up)("Vcode");return(0,n.wg)(),(0,n.iD)("div",null,[(0,n._)("div",i,[(0,n.Wm)(k,{model:w.value,class:"login_form"},{default:(0,n.w5)((function(){return[s,1==h.value?((0,n.wg)(),(0,n.iD)("div",r,[v,(0,n.wy)((0,n._)("input",{class:"list_inp","onUpdate:modelValue":l[0]||(l[0]=function(e){return w.value.username=e}),placeholder:"请输入账号"},null,512),[[a.nr,w.value.username]])])):(0,n.kq)("",!0),1==h.value?((0,n.wg)(),(0,n.iD)("div",c,[d,(0,n.wy)((0,n._)("input",{class:"list_inp","onUpdate:modelValue":l[1]||(l[1]=function(e){return w.value.password=e}),type:"password",placeholder:"请输入密码",onKeydown:(0,a.D2)(b,["enter","native"])},null,40,f),[[a.nr,w.value.password]])])):(0,n.kq)("",!0),o.value.length>1?((0,n.wg)(),(0,n.iD)("div",m,[p,(0,n.Wm)(t,{modelValue:w.value.role,"onUpdate:modelValue":l[2]||(l[2]=function(e){return w.value.role=e}),placeholder:"请选择用户类型"},{default:(0,n.w5)((function(){return[((0,n.wg)(!0),(0,n.iD)(n.HY,null,(0,n.Ko)(o.value,(function(e,l){return(0,n.wg)(),(0,n.j4)(u,{label:e.roleName,value:e.roleName},null,8,["label","value"])})),256))]})),_:1},8,["modelValue"])])):(0,n.kq)("",!0),(0,n._)("div",g,[1==h.value?((0,n.wg)(),(0,n.j4)(_,{key:0,class:"login",type:"success",onClick:b},{default:(0,n.w5)((function(){return[(0,n.Uk)("登录")]})),_:1})):(0,n.kq)("",!0),(0,n.Wm)(_,{class:"forget",onClick:U},{default:(0,n.w5)((function(){return[(0,n.Uk)("忘记密码")]})),_:1})])]})),_:1},8,["model"])]),(0,n.Wm)(y,{show:e.isShow,onSuccess:e.success,onClose:e.close,onFail:e.fail},null,8,["show","onSuccess","onClose","onFail"])])}}};var _=o(83744);const h=(0,_.Z)(w,[["__scopeId","data-v-5d56a896"]]),k=h}}]);
//# sourceMappingURL=463.b1fdf8f2.js.map