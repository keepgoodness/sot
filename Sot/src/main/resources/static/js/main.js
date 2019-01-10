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
	if (id === "") {
		return;
	}
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajax({
		method: "POST",
		url: url,
		data: {id: id},
		beforeSend: function (xhr) {
			xhr.setRequestHeader(header, token);
		},
		success: function (data, textStatus, xhr) {
			$(element).parent().remove();
			$("#info").empty();
		}
	});
}