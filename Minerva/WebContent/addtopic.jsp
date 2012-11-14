<h1>Legg til tråd</h1>
<br />
<div class="row">
	<form action="addtopic?subcategoryId=<%=request.getParameter("subcategoryId") %>"
			method="post" class="form-horizontal well span6">
		<div class="control-group">
			<label class="control-label" for="inputName">
				Navn:
			</label>
			<div class="controls">
				<input type="text" id="inputName" name="name" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputDescription">
				Beskrivelse:
			</label>
			<div class="controls">
				<textarea rows="5" name="description" id="inputDescription"></textarea>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn btn-primary btn-large">Lagre</button>
				<button type="button" class="btn btn-large"
					onclick="window.location='?page=subcategory&subcategoryId=<%=request.getParameter("subcategoryId")%>'">
						Avbryt
				</button>
			</div>
		</div>
	</form>
</div>
