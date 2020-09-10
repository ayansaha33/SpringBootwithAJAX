
$(document).ready(function () {

    $("#line-chart-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
		$( "#holder" ).empty();
        $( "#chartdraw" ).empty();
        $("#dynamic-data").empty();

        fire_ajax_submit();
		//populatechart();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username").val();

    $("#line-chart-btn").prop("disabled", true);
    $("#bar-chart-btn").prop("disabled", true);
    
    $.ajax({
        url: "/getSuccessBooking/fromSource",
        //url:"http://localhost:8080/getSuccessBooking/fromSource",
        success: function (data) {

		
			var sourcelocation=[];
            var successful_Booking=[];
            var cancelled_booking=[];
			
    for(var i in data.listofFlightBookingCount){
        sourcelocation.push(data.listofFlightBookingCount[i].source_location); 
        successful_Booking.push(data.listofFlightBookingCount[i].total_Successful_Booking);
        cancelled_booking.push(data.listofFlightBookingCount[i].total_Cancelled_Booking);
		$('<tr class="table-active">').html("<td>" + data.listofFlightBookingCount[i].source_location + "</td><td>" + data.listofFlightBookingCount[i].total_Successful_Booking + "</td><td>" + data.listofFlightBookingCount[i].total_Cancelled_Booking + "</td>").appendTo('#records-table');
    }
    console.log(sourcelocation);
    console.log(successful_Booking);
    console.log(cancelled_booking);
            /*var json = JSON.stringify(data);
            populatechart(data);
            $('#holder').html(json);*/

		
		//populateTable();
		
		var r = Raphael('chartdraw'),
                    txtattr = { font: "20px 'Fontin Sans', Fontin-Sans, sans-serif" };

                    var x = [], y = [], y2 = [], y3 = [];
                    for (var i = 0; i < 1e6; i++) {
                        x[i] = i * 10;
                        y[i] = (y[i - 1] || 0) + (Math.random() * 7) - 3;
                        y2[i] = (y2[i - 1] || 150) + (Math.random() * 7) - 3.5;
                        y3[i] = (y3[i - 1] || 300) + (Math.random() * 7) - 4;
                    }
                    //r.text(20, 20, "Symbols, axis and hover effect").attr(txtattr);
                
                    //r.text(250, 30, "Line Chart").attr(txtattr);
                
                
                    var lines = r.linechart(20, 20, 350, 250, [[1, 2, 3, 4, 5, 6, 7],[3.5, 4.5, 5.5, 6.5, 7, 8]],
								 [successful_Booking, cancelled_booking],
								 { nostroke: false, axis: "0 0 1 1", symbol: "circle", smooth: true })
							.hoverColumn(function () {
                        this.tags = r.set();
    
                        for (var i = 0, ii = this.y.length; i < ii; i++) {
                            this.tags.push(r.tag(this.x, this.y[i], this.values[i], 160, 10).insertBefore(this).attr([{ fill: "#fff" }, { fill: this.symbols[i].attr("fill") }]));
                        }
                    }, function () {
                        this.tags && this.tags.remove();
                    });
    
                    lines.symbols.attr({ r: 6 });   
                    //r.dotchart(0, 0, 200, 250, [76, 70, 67, 71], [0, 1, 2, 3], successful_Booking, {max: 10, axisylabels: sourcelocation , heat: true, axis: '0 0 1 1'})



            console.log("SUCCESS : ", data);
            $("#line-chart-btn").prop("disabled", false);
            $("#bar-chart-btn").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h3>Ajax Response</h3>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#holder').html(json);

            console.log("ERROR : ", e);
            $("#line-chart-btn").prop("disabled", false);
            $("#bar-chart-btn").prop("disabled", false);

        }
    });

}

			function populateTable(){
				
				// 1. remove all existing rows
		$("tr:has(td)").remove();
		
		// 2. get each booking
		$.each(data.listofFlightBookingCount, function (index, booking) {
		
		    // 2.2 Create table column for categories
		    var origin_country_column = $("<td/>");
		
		    // 2.3 get each origin of this booking
		    $.each(booking.source_location, function (i, origin) {
		        var span = $("<span/>");
		        span.text(origin);
		        origin_country_column.append(span);
		    });
		
		    // 2.4 Create table column for tags
		   var successful_booking_count = $("<td/>");
		
		    // 2.5 get each successful booking count of this booking    
		    $.each(booking.total_Successful_Booking, function (i, sucess_count) {
		        var span = $("<span/>");
		        span.text(sucess_count);
		        successful_booking_count.append(span);
		    });
		
		    // 2.6 Create a new row and append 2 columns (origin_country_column, successful_booking_count)
		    $("#records-table").append($('<tr/>')
		            .append(origin_country_column)
		            .append(successful_booking_count)
		    ); 
		});  
				
			}

/*function populatechart(jsonObject) {

    var data=[];
    for(var i in jsonObject.listofFlightBookingCount){
        data.push(jsonObject.listofFlightBookingCount[i]); 
    }
    console.log(data);
                var r = Raphael("chartdraw"),
                    fin = function () {
                        this.flag = r.popup(this.bar.x, this.bar.y, this.bar.value || "0").insertBefore(this);
                    },
                    fout = function () {
                        this.flag.animate({opacity: 0}, 300, function () {this.remove();});
                    },
                    txtattr = { font: "20px 'Fontin Sans', Fontin-Sans, sans-serif" };
                
                r.text(320, 100, "Single Series Chart").attr(txtattr);
                //r.text(480, 10, "Multiline Series Stacked Chart").attr(txtattr);
                //r.text(160, 250, "Multiple Series Chart").attr(txtattr);
               // r.text(480, 250, "Multiline Series Stacked Chart\nColumn Hover").attr(txtattr);
                
                //r.barchart(100, 100, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10]]).hover(fin, fout);
                r.barchart(100, 100, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10]]).hover(fin, fout);

                //r.hbarchart(330, 10, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10], [10, 2, 1, 5, 32, 13, 20, 55]], {stacked: true}).hover(fin, fout);
                //r.hbarchart(10, 250, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10], [10, 2, 1, 5, 32, 13, 20, 55]]).hover(fin, fout);
               // var c = r.barchart(330, 250, 300, 220, [[55, 20, 13, 32, 5, 1, 2, 10], [10, 2, 1, 5, 32, 13, 20, 55]], {stacked: true, type: "soft"}).hoverColumn(fin2, fout2);
}*/

