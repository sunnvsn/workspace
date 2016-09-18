window.RpcContext.beans['_CookieBean']={
   getCookie:function(arg0,callbackObj){
      var request={
          functionName:'_CookieBean.getCookie',
          paramters:JSON.stringify({
          arg0:arg0
          })
      };
      if(callbackObj!=null){
            RpcContext.invoke(request,this.realBaseURL,callbackObj);
      }else{
            return RpcContext.invoke(request,this.realBaseURL,callbackObj);
      }
   },
   addCookie:function(arg0,callbackObj){
      var request={
          functionName:'_CookieBean.addCookie',
          paramters:JSON.stringify({
          arg0:arg0
          })
      };
      if(callbackObj!=null){
            RpcContext.invoke(request,this.realBaseURL,callbackObj);
      }else{
            return RpcContext.invoke(request,this.realBaseURL,callbackObj);
      }
   },
   removeCookie:function(arg0,callbackObj){
      var request={
          functionName:'_CookieBean.removeCookie',
          paramters:JSON.stringify({
          arg0:arg0
          })
      };
      if(callbackObj!=null){
            RpcContext.invoke(request,this.realBaseURL,callbackObj);
      }else{
            return RpcContext.invoke(request,this.realBaseURL,callbackObj);
      }
   }
}
;
  if(document.location.href.startWith('http')){ window.RpcContext.beans['_CookieBean'].realBaseURL='.'; } else {
  window.RpcContext.beans['_CookieBean'].realBaseURL=window._RpcDefaultBaseURL; } ;
