let index = {
    init : function (){
        $("#btn-email-send").on("click",()=>{
            this.send();
        });
    },

    send : function (){
        let data ={
            emailAddress : $("#box-email").val(),
            emailAgree : $("#email-agree-checkbox").is(':checked')
        };

        let regexEmail = new RegExp("([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\"\(\[\]!#-[^-~ \t]|(\\[\t -~]))+\")@([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\[[\t -Z^-~]*])");
        if(!regexEmail.test(data.emailAddress)){
            alert("이메일 형식이 올바르지 않습니다.");
        } else if(!data.emailAgree) {
            alert("이메일 수집에 동의하지 않았습니다.")
        } else {
            $.ajax({
                type: "POST",
                url: "/send",
                data: JSON.stringify(data), // javascript object인 data를 json 형식으로 변환해서 java가 인식할 수 있도록 준비함
                contentType: "application/json; charset=utf-8", // http body 데이터가 어떤 타입인지(MIME)
                dataType: "json" // 요청에 대한 응답이 왔을 때 기본적으로 문자열(생긴게 json이라면)=> javascript object로 변경해줌
            }).done(function (resp) {
                if (resp.status === 500) {
                    alert("이메일 발송 실패");
                } else {
                    alert("이메일 발송 완료");
                }
                location.href = "/";
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }

    }
}


index.init();

