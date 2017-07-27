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

$(document).ready(function () {
    $(".cartItemQty").on('change', function () {
        var id = this.id;

        $('#update-item-' + id).css('display', 'inline-block');
    });
    $("#theSameAsShippingAddress").on('click', checkBillingAddress);
});