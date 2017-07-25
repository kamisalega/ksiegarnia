/**
 * Created by kamilsalega on 25.07.2017.
 */


$(document).ready(function () {
    $(".cartItemQuantity").on('change', function () {
        var id = this.id;
        console.log("test");
        $('#update-item-' + id).css('display', 'inline-block');
    });
});