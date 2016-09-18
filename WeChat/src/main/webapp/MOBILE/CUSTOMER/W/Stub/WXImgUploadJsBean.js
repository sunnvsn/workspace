window.RpcContext.beans['WXImgUploadJsBean']={
   getWXConfigData:function(arg0,callbackObj){
      var request={
          functionName:'WXImgUploadJsBean.getWXConfigData',
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
   uploadClaimImages:function(arg0,callbackObj){
      var request={
          functionName:'WXImgUploadJsBean.uploadClaimImages',
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
  if(document.location.href.startWith('http')){ window.RpcContext.beans['WXImgUploadJsBean'].realBaseURL='.'; } else {
  window.RpcContext.beans['WXImgUploadJsBean'].realBaseURL=window._RpcDefaultBaseURL; } ;
