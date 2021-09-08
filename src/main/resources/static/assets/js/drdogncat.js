function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
    results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getDttm(current_datetime) {
    let formatted_date = current_datetime.getFullYear() + "-" + (current_datetime.getMonth() + 1) + "-" + current_datetime.getDate() + " " + current_datetime.getHours() + ":" + current_datetime.getMinutes() + ":" + current_datetime.getSeconds();
    return formatted_date;
}

function isEmpty(value){
    if( value == "" || value == null || value == undefined || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
        return true
    } else {
        return false
    }
}

/* 휴대폰번호 정규식 */
function checkPhoneNumber(a){
    var regExp_Phone = /^\d{3}\d{3,4}\d{4}$/;
    if(!regExp_Phone.test(a.value)){
        addDiv(a,'휴대폰 번호');
        a.value='';
        a.focus();
        return false;
    }
    return true;
}

/* 이메일 정규식 */
function checkEmail(a){
    var regExp_Email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if(!regExp_Email.test(a.value)){
        addDiv(a,'이메일 주소');
        a.value='';
        a.focus();
        return false;
    }
    return true;
}
