function ajaxGetPoint(url, paramId) {
    centeringMarker(paramId);
    $.ajax({
        method: "GET",
        url: url,
        data: {id: paramId},
        success: function (point) {
            if (point.company === null) {
                $("#аddCompany").css("display", "inline");
                $("#аddCompany").attr("href", '/point-add-company/' + paramId);
                $("#аddCompany").find('input').attr("value", paramId);
            } else {
                $("#аddCompany").css("display", "none");
            }

            $("#updDellButt").css("display", "inline");
            $("#edit").attr("href", '/point-edit/' + paramId);
            $("#delete").find('input').attr("value", paramId);

            $("#excPdfButt").css("display", "inline");
            $("#downlExcel").attr("href", '/point-excel/' + paramId);
            $("#downlPdf").attr("href", '/point-pdf' + paramId);

            $("#form").css("display", "flex");
            $("#objName").html(point.name);
            $("#identifier").html(point.identifier);
            $("#place").html(point.address.place.name);
            $("#street").html(point.address.street.name);
            $("#number").html(point.address.number);
            $("#entrance").html(point.address.entrance);
            $("#floor").html(point.address.floor);
            $("#apartment").html(point.address.apartment);
            $("#sse_status").html((point.sseStatus === "FREE" ? "Безплатен" : "Платен"));
            $("#sot").attr("checked", ((point.hasSot) ? "checked" : null));
            $("#video").attr("checked", ((point.hasVideo === true) ? "checked" : null));

            //фирма
            if (point.company !== null) {
                $("#companyInfo").css("display", "flex");
                $("#companyInfo").prop("disable", "false");

                $("#companyBulstat").html(point.company.bulstat);
                $("#companyMrpFName").html(point.company.mrp.firstName);
                $("#companyMrpMName").html(point.company.mrp.middleName);
                $("#companyMrpLName").html(point.company.mrp.lastName);

                $("#companyPlace").html(point.company.address.place.name);
                $("#companyStreet").html(point.company.address.street.name);
                $("#companyNumber").html(point.company.address.number);
                $("#companyEntrance").html(point.company.address.entrance);
                $("#companyFloor").html(point.company.address.floor);
                $("#companyApartment").html(point.company.address.apartment);

                $("#companyRecFName").html(point.company.recipient.firstName);
                $("#companyRecMName").html(point.company.recipient.middleName);
                $("#companyRecLName").html(point.company.recipient.lastName);
                $("#vat_status").html((point.company.vatStatus === "YES" ? "Да" : "Не"));
                $("#vatCode").html((point.company.vatStatus === "YES" ? point.company.vatCode : ""));
            } else {
                $("#companyInfo").css("display", "none");
                $("#companyInfo").prop("disable", "true");
            }

        }});
}

// delete Point via AJAX
$("#delete").click(function () {
    var customerId = $(this).find('input').val();
    $.ajax({
        method: "DELETE",
        url: "/points/delete/" + customerId,
        success: function (result) {
            location.reload();
        },
        error: function (e) {
            alert(e);
        }
    });

});

//STRAT Autocomplete for search input
$(document).ready(function () {
    $('#input-search').autocomplete({
        minChars: 2,
        serviceUrl: actionAutocomplete,
        params: {dataSearch: function () {
                return $('#input-search').val();
            },
            typeSearch: function () {
                return $("input[type='radio'][name='search-radio']:checked").val();
            }},
        noCache: true,
        delimiter: ",",
        onSelect: function (selected) {
            $('#input-search').attr("data", selected.data);
            autocompletePointId = selected.data;
            return false;
        },
        transformResult: function (response) {
            return {
                suggestions: $.map($.parseJSON(response), function (item) {

                    return {
                        value: item.name,
                        data: item.id
                    };
                }),

            };
        }
    }).keypress(function (e) {
        var code = (e.keyCode ? e.keyCode : e.which);
        if (code === 13) { //Enter keycode
            if ($('#input-search').val().length > 2) {
                ajaxGetPoint(actionAjax, autocompletePointId);
                switchIcon(markersOnMap.get(autocompletePointId));
                $('#input-search').val("");
            }
            return false;
        }
    });
});
$('#button-search').click(function () {
    if ($('#input-search').val().length > 2) {
        ajaxGetPoint(actionAjax, autocompletePointId);
        switchIcon(markersOnMap.get(autocompletePointId));
        $('#input-search').val("");
    }
});
//END Autocomplete for search input