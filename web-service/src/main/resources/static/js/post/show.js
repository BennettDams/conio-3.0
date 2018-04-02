var quill = new Quill('#body-content', {
  modules: {
    toolbar: [
      [{ header: [1, 2, false] }],
      ['bold', 'italic', 'underline'],
      ['image', 'code-block']
    ]
  },
  readOnly : true,
  placeholder: 'Nothing found',
  theme: 'bubble'
});

let body = document.querySelector('#body').value;

// Populate body-content content

quill.setContents(JSON.parse(body));