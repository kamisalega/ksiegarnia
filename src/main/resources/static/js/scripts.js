/**
 * Created by kamilsalega on 25.07.2017.
 */


function checkBillingAddress() {
    if ($("#theSameAsShippingAddress").is(":checked")) {
        $(".billingAddress").prop("disabled", true);
    } else {
        $(".billingAddress").prop("disabled", false);
    }
}

function checkPasswordMatch() {

    var password = $("#newPassword").val();
    var confirmPassword = $("#confirmPassword").val();

    if (password == "" && confirmPassword == "") {
        $("#checkPasswordMatch").html("");
        $("#updateUserInfoButton").prop('disabled', false);
    } else {

        if (password != confirmPassword) {
            $("#checkPasswordMatch").html("Hasła nie pasują do siebie!");
            $("#updateUserInfoButton").prop('disabled', true);
        } else {
            $("#checkPasswordMatch").html("Hasła pasują do siebie!");
            $("#updateUserInfoButton").prop('disabled', false);
        }

    }

}

$(document).ready(function () {
    $(".cartItemQuantity").on('change', function () {
        var id = this.id;

        $('#update-item-' + id).css('display', 'inline-block');
    });
    $("#theSameAsShippingAddress").on('click', checkBillingAddress);
    $("#confirmPassword").keyup(checkPasswordMatch);
    $("#newPassword").keyup(checkPasswordMatch);
});