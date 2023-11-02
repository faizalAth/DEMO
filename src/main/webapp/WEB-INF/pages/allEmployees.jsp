<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" media="all" />
    <title>ATH Empire</title>
  </head>
  <body>
    <h1>List of Employees</h1>
	<div class="card p-3">
		<div class="row">
			<div class="ofset-3 col-6 ofset-3">
				<table class="table table-striped" id="tableDataId">
					<thead>
						<tr>
							<th class="text-center" style="border: 1px solid black"
								scope="col">#</th>
							<th class="text-center" style="border: 1px solid black"
								scope="col">Name</th>
							<th class="text-center" style="border: 1px solid black"
								scope="col">City</th>
						</tr>
					</thead>
					<tbody id="tBodyId">

					</tbody>
				</table>
			</div>
		</div>
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	  getAllEmployee();
  });
  
  function getAllEmployee(){
	  $.ajax({
			url:"${pageContext.servletContext.contextPath}/a1/employee",
			type:"GET",
			dataType:"json",
			headers:{
				'accept':'application/json'
			},
			success:function(resData){
				$.each(resData,function(index){
					$('#tBodyId').append( 
						$('<tr/>').append(
							$('<td/>').addClass('text-center').css({'border':'1px solid black'}).append(resData[index].empid)		
						).append(
							$('<td/>').addClass('text-center').css({'border':'1px solid black'}).append(resData[index].name)		
						).append(
							$('<td/>').addClass('text-center').css({'border':'1px solid black'}).append(resData[index].city)		
						)
					)
				});
				$('#tableDataId').DataTable();
			},
			error:function(){
				
			}	
		}); 
  }
  
  
  </script>
  </body>
</html>