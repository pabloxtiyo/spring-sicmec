/**
 * 
 */

$( document ).ready(function() {
  
	$(".datatables").DataTable({
		"scrollY":        "250px",
        "scrollCollapse": true,
        "aoColumns": 
        	[
        	 { "sWidth": "10%", "sClass": "center", "bSortable": false },
        	 { "sWidth": "10%" },
        	 { "sWidth": "10%" },
        	 { "sWidth": "10%" },
        	 { "sWidth": "10%" },
        	 { "sWidth": "10%" },
        	 { "sWidth": "10%" },
             { "sWidth": "10%" },
            ],
	});
});