window.RpcContext.beans['WeChatImgJsBean']={
   CommitData:function(arg0,arg1,arg2,arg3,callbackObj){
      var request={
          functionName:'WeChatImgJsBean.CommitData',
          paramters:JSON.stringify({
          arg0:arg0,
          arg1:arg1,
          arg2:arg2,
          arg3:arg3
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
  if(document.location.href.startWith('http')){ window.RpcContext.beans['WeChatImgJsBean'].realBaseURL='.'; } else {
  window.RpcContext.beans['WeChatImgJsBean'].realBaseURL=window._RpcDefaultBaseURL; } ;
