let index = {
    init: function () {
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        }

        // ajax 호출시 default 비동기 호출
        $.ajax({
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(response){
            alert("회원가입이 완료되었습니다.");
            console.log(response);
            location.href = "/blog";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();