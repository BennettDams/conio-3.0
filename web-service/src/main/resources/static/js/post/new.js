let quill = new Quill('#editor-container', {
	modules : {
		toolbar : [
			[ 'bold', 'italic' ],
			[ 'link', 'blockquote', 'code-block', 'image' ],
			[ {
				list : 'ordered'
			}, {
				list : 'bullet'
			} ]
		]
	},
	placeholder : 'Compose an epic...',
	theme : 'snow'
});

let form = document.querySelector('form');
form.onsubmit = function() {
	// Populate hidden form on submit
	let body = document.querySelector('input[name=body]');
	body.value = JSON.stringify(quill.getContents());
	
};