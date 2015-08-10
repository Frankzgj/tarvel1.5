/**
 * 
 */
//将数据插入表格
 function contactList(jsons){
	 var table = document.getElementById("contactTable");
     var arr = eval("(" + jsons + ")"); 
     if(arr.length == 0){     
     	alert("输入有误或查询不到有关信息，请重新输入")
     }else{
	 	 for(var i = 0; i <= arr.length; i++){
				var jsonObj = arr[i]; //获取json对象
				var tr = table.insertRow(table.rows.length);//获取table列数
				var td1 = tr.insertCell(0);
				td1.align = "center";
				var td2 = tr.insertCell(1);
				td2.align = "center";
				var td3 = tr.insertCell(2);
				td3.align = "center";
				var td4 = tr.insertCell(3);
				td4.align = "center";
				var td5 = tr.insertCell(4);
				td5.align = "center";
								 
				td1.innerHTML = jsonObj.target_Id;
				td2.innerHTML = jsonObj.target_Name;
				td3.innerHTML = jsonObj.desc;
				td4.innerHTML = jsonObj.province_Name;
				td5.innerHTML = jsonObj.city_Name;
		}
     }
 }
    //创建XMLHttpReques对象  
    function createXMLHttpRequest(){  
          
        if(window.XMLHttpRequest){  
            //Mozilla浏览器  
            XMLHttpReq=new XMLHttpRequest();  
        }else{  
            //IE浏览器  
            if(window.ActiveXObject){  
                try{  
                    XMLHttpReq=new ActionXObject("Msxm12.XMLHTTP");  
                }catch(e){  
                    try{  
                        XMLHttpReq=new ActiveXObject("Microsoft.XMLHTTP");  
                    }catch(e){}  
                }  
            }  
        }  
    }  
    
    //处理服务器响应结果  
     function handleResponse() {  
        // 判断对象状态  
        if (XMLHttpReq.readyState == 4) {   
            // 信息已经成功返回，开始处理信息  
           if (XMLHttpReq.status == 200) {   
        	   var j =XMLHttpReq.responseText;
       	       contactList(j);
              }  
         }  
       }  
    
    //发送客户端的请求  
    function sendRequest(url){  
        //1.创建XMLHttpRequest  
        createXMLHttpRequest();  
        //2.设置回调函数  
        XMLHttpReq.onreadystatechange=handleResponse;  
        //3.初始化XMLHttpRequest组建并发送请求  
        XMLHttpReq.open("get",url,true);  
        //发送请求  
       XMLHttpReq.send(null);   
    }  
    
  
    //开始调用Ajax的功能  
    function getByParentTargetId()  
    {  
        var parentTargetId=document.getElementById("parentTargetId").value;  
        //发送请求  
        sendRequest("target?parentTargetId="+parentTargetId);  
    }  
