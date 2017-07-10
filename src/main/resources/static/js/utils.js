function htmlTableForDataTable(columns, id){
	var htmlTable = '<table id="' + id + '" class="table table-striped table-bordered table-condensed" cellspacing="0" width="100%"><thead><tr>';                	
	
	jQuery.each(columns, function(i, column) {
		htmlTable += '<th>' + column + '</th>';
	});
	
	htmlTable += '</tr></thead></table>';
	
	return htmlTable;
}

function drawResultStructure(searchInput){
	$.ajax({
	    
		url: "/result-structure",
	    dataType: "json",
	    data: { query: searchInput },
	    cache: false,
	    success: function(response) { 
	
	    	var htmlTable = htmlTableForDataTable(response.columns, 'query-data-tab-dt');
	   		
	        $('#query-data-tab').html(htmlTable);
	        
	        $('#query-data-tab-dt').DataTable( {
	            "processing": true,
	            "serverSide": true,
	            "bLengthChange": false,
	            "bFilter": false,
	            "bSort": false,
	            "pageLength": 25,
	            "createdRow": function ( row, data, index ) {
	                    //$('td', row).eq(index).attr('title', data[index]);
                },
	            "columnDefs": [
	                {"className": "dt-center", "targets": "_all"}
	            ],
	            "ajax": {
	                 "url" : "/query-data",
	                 "data": function( d ) {
	                        d.searchInput = searchInput;
	                  }
	             }
	        });
	    },
	   error: function (request, status, error) {
	        handleError();
	   }
	});// end of $.ajax search-meta
}

function handleError(){
     $('#query-plan-tab-dt').remove();
     $('#query-data-tab-dt').remove();
     $('#query-plan-tab').tab('show');
     $('#query-plan-tab').html('<h4>Error occurred on the server side. We are working on it</h4>');
     $('#query-data-tab').html('<h4>Error occurred on the server side. We are working on it</h4>');
}

function drawQueryPlan(searchInput){
	 $.ajax({
    
		 url: "/query-plan",
		 dataType: "json",
		 data: { query: searchInput },
		 success: function(response) {
			 
			 $('#query-plan-tab-dt').remove();
			 $('#query-data-tab-dt').remove();
    	
			 drawSqlAndPlanTable(response);		     
		        
		     $('#query-plan-tab-dt').DataTable( {
	            "bFilter": false,
	            "bPaginate": false,
	            "bLengthChange": false,
	            "bInfo": false,
	            "bSort": false,
	            "data": response.data,
	            "lengthMenu": [[-1], ["All"]],
	            "aoColumnDefs": [            
	            	 {
	            		 "aTargets": [ 0, 1, 2, 3, 4, 5 ], // Column to target
		                 "mRender": function ( data, type, full ) {
		                   	return '<pre class="pre-cell" style="margin: 0; padding: 0">' + data + '</pre>';
		                 }
	                 }
	             ]
		      });
	     
		 },//end of success

		 error: function (request, status, error) {
		    handleError();
		}
	 });
}

function drawSqlAndPlanTable(response){
	
    var planTable = htmlTableForDataTable(response.columns, 'query-plan-tab-dt');    

	var html = '<table width="100%"><tr><td><pre id="sql-placeholder" class="sql"><code>' 
		+ response.sql 
		+'</code></pre></td></tr>';

	 html += '<tr><td>' + planTable + '</td></tr></table>';
     $('#query-plan-tab').html(html);
     hljs.highlightBlock($('#sql-placeholder')[0]);
}

function init(){
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		
		var tabIndex = $(e.target).parent().index();
		
		if(tabIndex == 1){
			var searchInput = $("#query").val();
			drawResultStructure(searchInput);
		}
		
		$($.fn.dataTable.tables(true)).DataTable().columns.adjust();
	});
}

function getParameterByName(name) {
    
    var url = window.location.href;
    
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}