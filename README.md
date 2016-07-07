#Possible Wicket Bug.

A control which has a style sheet reference in its <wicket:head> section.

1) The control is used on a ListView. Initially it is not visible.

 
2) Make the control visible via Ajax. 
The style sheet link is added to the page head but if looks malformed.
```
<head>
  <link type="null" href="status.css" rel="stylesheet" id="null">
</head>
```
 
3) Full page refresh corrects error.
```
<head>
  <link href="status.css" rel="stylesheet">
</head>
```
 