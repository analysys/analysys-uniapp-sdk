!function(t){var e={};function n(o){if(e[o])return e[o].exports;var i=e[o]={i:o,l:!1,exports:{}};return t[o].call(i.exports,i,i.exports,n),i.l=!0,i.exports}n.m=t,n.c=e,n.d=function(t,e,o){n.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:o})},n.r=function(t){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},n.t=function(t,e){if(1&e&&(t=n(t)),8&e)return t;if(4&e&&"object"==typeof t&&t&&t.__esModule)return t;var o=Object.create(null);if(n.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var i in t)n.d(o,i,function(e){return t[e]}.bind(null,i));return o},n.n=function(t){var e=t&&t.__esModule?function(){return t.default}:function(){return t};return n.d(e,"a",e),e},n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},n.p="",n(n.s=18)}([function(t,e){t.exports={"uni-icon":{fontFamily:"uniicons",fontWeight:"normal"},"uni-bg-red":{backgroundColor:"#F76260",color:"#FFFFFF"},"uni-bg-green":{backgroundColor:"#09BB07",color:"#FFFFFF"},"uni-bg-blue":{backgroundColor:"#007AFF",color:"#FFFFFF"},"uni-container":{flex:1,paddingTop:"15",paddingRight:"15",paddingBottom:"15",paddingLeft:"15",backgroundColor:"#f8f8f8"},"uni-padding-lr":{paddingLeft:"15",paddingRight:"15"},"uni-padding-tb":{paddingTop:"15",paddingBottom:"15"},"uni-header-logo":{paddingTop:"15",paddingRight:"15",paddingBottom:"15",paddingLeft:"15",flexDirection:"column",justifyContent:"center",alignItems:"center",marginTop:"10upx"},"uni-header-image":{width:"80",height:"80"},"uni-hello-text":{marginBottom:"20"},"hello-text":{color:"#7A7E83",fontSize:"14",lineHeight:"20"},"hello-link":{color:"#7A7E83",fontSize:"14",lineHeight:"20"},"uni-panel":{marginBottom:"12"},"uni-panel-h":{backgroundColor:"#ffffff",flexDirection:"row",alignItems:"center",paddingTop:"12",paddingRight:"12",paddingBottom:"12",paddingLeft:"12"},"uni-panel-h-on":{backgroundColor:"#f0f0f0"},"uni-panel-text":{flex:1,color:"#000000",fontSize:"14",fontWeight:"normal"},"uni-panel-icon":{marginLeft:"15",color:"#999999",fontSize:"14",fontWeight:"normal",transform:"rotate(0deg)",transitionDuration:0,transitionProperty:"transform"},"uni-panel-icon-on":{transform:"rotate(180deg)"},"uni-navigate-item":{flexDirection:"row",alignItems:"center",backgroundColor:"#FFFFFF",borderTopStyle:"solid",borderTopColor:"#f0f0f0",borderTopWidth:"1",paddingTop:"12",paddingRight:"12",paddingBottom:"12",paddingLeft:"12","backgroundColor:active":"#f8f8f8"},"uni-navigate-text":{flex:1,color:"#000000",fontSize:"14",fontWeight:"normal"},"uni-navigate-icon":{marginLeft:"15",color:"#999999",fontSize:"14",fontWeight:"normal"},"uni-list-cell":{position:"relative",flexDirection:"row",justifyContent:"flex-start",alignItems:"center"},"uni-list-cell-pd":{paddingTop:"22upx",paddingRight:"30upx",paddingBottom:"22upx",paddingLeft:"30upx"},"flex-r":{flexDirection:"row"},"flex-c":{flexDirection:"column"},"a-i-c":{alignItems:"center"},"j-c-c":{justifyContent:"center"},"list-item":{flexDirection:"row",paddingTop:"10",paddingRight:"10",paddingBottom:"10",paddingLeft:"10"},"@VERSION":2}},function(t,e,n){"use strict";function o(t,e,n,o,i,r,a,u,l,c){var f,d="function"==typeof t?t.options:t;if(l){d.components||(d.components={});var s=Object.prototype.hasOwnProperty;for(var p in l)s.call(l,p)&&!s.call(d.components,p)&&(d.components[p]=l[p])}if(c&&((c.beforeCreate||(c.beforeCreate=[])).unshift((function(){this[c.__module]=this})),(d.mixins||(d.mixins=[])).push(c)),e&&(d.render=e,d.staticRenderFns=n,d._compiled=!0),o&&(d.functional=!0),r&&(d._scopeId="data-v-"+r),a?(f=function(t){(t=t||this.$vnode&&this.$vnode.ssrContext||this.parent&&this.parent.$vnode&&this.parent.$vnode.ssrContext)||"undefined"==typeof __VUE_SSR_CONTEXT__||(t=__VUE_SSR_CONTEXT__),i&&i.call(this,t),t&&t._registeredComponents&&t._registeredComponents.add(a)},d._ssrRegister=f):i&&(f=u?function(){i.call(this,this.$root.$options.shadowRoot)}:i),f)if(d.functional){d._injectStyles=f;var g=d.render;d.render=function(t,e){return f.call(e),g(t,e)}}else{var m=d.beforeCreate;d.beforeCreate=m?[].concat(m,f):[f]}return{exports:t,options:d}}n.d(e,"a",(function(){return o}))},function(t,e,n){Vue.prototype.__$appStyle__={},Vue.prototype.__merge_style&&Vue.prototype.__merge_style(n(3).default,Vue.prototype.__$appStyle__)},function(t,e,n){"use strict";n.r(e);var o=n(0),i=n.n(o);for(var r in o)"default"!==r&&function(t){n.d(e,t,(function(){return o[t]}))}(r);e.default=i.a},,function(t,e,n){"use strict";var o=n(14),i=n(9),r=n(1),a=Object(r.a)(i.default,o.b,o.c,!1,null,null,"061fb584",!1,o.a,void 0);e.default=a.exports},,,,function(t,e,n){"use strict";var o=n(10),i=n.n(o);e.default=i.a},function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=t("DCTestUniPlugin-TestModule"),o=t("AnalysysPlugin-UniAnalysysAgentModule"),i={methods:{testAsyncFunc:function(){n.testAsyncFunc({name:"uni-app",age:1},(function(t){uni.showToast({title:"\u8c03\u7528\u5f02\u6b65\u65b9\u6cd5 "+t,icon:"none"})}))},testSyncFunc:function(){var t=n.testSyncFunc({name:"uni-app",age:1});uni.showToast({title:"\u8c03\u7528\u540c\u6b65\u65b9\u6cd5 "+t,icon:"none"})},SDKVersion:function(){o.registerSuperProperty("ccc",{name:"uni-app",age:1})}}};e.default=i}).call(this,n(19).default)},,,,function(t,e,n){"use strict";n.d(e,"b",(function(){return o})),n.d(e,"c",(function(){return i})),n.d(e,"a",(function(){}));var o=function(){var t=this.$createElement,e=this._self._c||t;return e("scroll-view",{staticStyle:{flexDirection:"column"},attrs:{scrollY:!0,showScrollbar:!0,enableBackToTop:!0,bubble:"true"}},[e("div",[e("button",{attrs:{type:"primary"},on:{click:this.testAsyncFunc}},[this._v("testAsyncFunc")]),e("button",{attrs:{type:"primary"},on:{click:this.testSyncFunc}},[this._v("testSyncFunc")]),e("button",{attrs:{type:"primary"},on:{click:this.SDKVersion}},[this._v("SDKVersion")])],1)])},i=[]},,,,function(t,e,n){"use strict";n.r(e);n(2);var o=n(5);"undefined"==typeof Promise||Promise.prototype.finally||(Promise.prototype.finally=function(t){var e=this.constructor;return this.then((function(n){return e.resolve(t()).then((function(){return n}))}),(function(n){return e.resolve(t()).then((function(){throw n}))}))}),o.default.mpType="page",o.default.route="pages/sample/ext-module",o.default.el="#root",new Vue(o.default)},function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default=function(t){return weex.requireModule(t)}}]);