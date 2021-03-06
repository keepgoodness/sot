
function switchIcon(marker) {
    markersOnMap.forEach(function (element) {
        if (marker === element) {
            if (element.getIcon().url === icons.def) {
                var icon = {
                    url: icons.cur,
                    labelOrigin: new google.maps.Point(42, 20)
                };
                element.setIcon(icon);
                var label = {
                    text: element.getTitle().substr(0, 1),
                    color: "#eb3a44",
                    fontSize: "18px",
                    fontFamily: 'Verdana',
                    fontWeight: "bold"
                };
                element.setLabel(label);
                element.setZIndex(1);
            }
        } else {
            var icon = {
                url: icons.def,
                labelOrigin: new google.maps.Point(30, 14)
            };
            var label = {
                text: element.getLabel().text,
                color: 'white',
                fontFamily: 'Verdana',
                fontWeight: 'bold'}
            element.setIcon(icon);
            element.setLabel(label);
            element.setZIndex(-1);
        }
    });
}

function centeringMarker(id) {
    var pos = markersOnMap.get(id).getPosition();
    map.setZoom(16);
    map.panTo(new google.maps.LatLng(pos.lat(), pos.lng()));
}

function deleteElement(url, element) {
    let id = element.getAttribute("data");
    if (id === "")
        return;
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        method: "POST",
        url: context + url,
        data: {id: id},
        beforeSend: function (xhr) {
            if (typeof header !== 'undefined' || typeof token !== 'undefined') {
                xhr.setRequestHeader(header, token);
            }
        },
        statusCode: {
            200: function () {
                $("#info").empty();
                $(element).parent().remove();
            },
            404: function () {
//				$(element + "div:last-child").html("Този контролен модул не съществува!");
                alert($(element).parent().parent().children().last().html("Този контролен модул не съществува!"));
            },
            409: function (obj) {
                alert(obj.responseText);
            }
        }
    });
}

function createLiInfo(brand, sensorModel, sensorId, count) {
    var li = $('<li />');
    $(li).addClass('list-group-item d-flex justify-content-between align-items-center');

    var label = $('<span />').text(brand + " | " + sensorModel);
    $(li).append(label);

    var countNum = $('<span />');
    $(countNum).addClass('badge-primary badge-pill');
    $(countNum).text(count);


    var countLabel = $('<span />');
    $(countLabel).text((count < 2) ? "Брой" : "Броя");

    $(li).append(countNum);
    $(li).append(countLabel);

    var div = $('<div />').addClass('btn btn-sm');
    $(div).attr("data", sensorId);

    var img = $('<img />').attr("src", context + "/images/delete_28px.png");
    $(div).append(img);
    $(div).click(function (element) {
        deleteElementFromHTMLDom($(this));
        deleteSensorFromArray($(this).attr("data"));
    });

    $(li).append(div);
    $("#sensors").append(li);

}

function deleteSensorFromArray(sensorId) {
    var array = components.sensors;
    var indexOf;
    array.forEach(function (item, index) {
        if (item.id == sensorId) {
            array.splice(index, 1);
        }
    })
    var position = array.indexOf(indexOf);

}

function deleteElementFromHTMLDom(element) {
    $(element).parent().remove();
}

function addSensorToArrayIfNotPresent(sensorId, count) {
    var array = components.sensors
    var newsensor = {"id": sensorId, "count": count};
    var isPresent = false;

    for (item of array) {
        if (item.id === sensorId) {
            isPresent = true;
            break;
        }
    }
    if (isPresent) {
        return array.length;
    } else {
        return array.push(newsensor);
    }
}