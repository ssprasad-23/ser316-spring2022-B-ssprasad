Code Review Defect List

Reviewer: _____________________________	GH Repo: ________________________________


###ID #	Location	Problem Description	Problem
###File and Line Number 		Category	Severity

###01	Cart.java, Line: 5	    -All public classes must have a class banner comment present and filled in.	- CG
###02	Cart.java, Lines: 8-10  -All attributes must be private (class member variables, not constants)	-CG
###03.	Cart.java, Line: 67	    -All complex statements (if, else, switch, loops) must use explicit {} even if the body is a single line. -CG
###04.	Cart.java, Line: 37	    -Variable, Parameter, and Method names should be in lower camelCase, with the first letter in lowercase (example: fooBar). -CG
###05.	Cart.java, Lines: 83-97	-Removed switch statement, and update to if else - CS
###06.	Cart.java, Line:81 	    -twoLetterUSStateAbbreviation is Too long identifiers	CS
###07.	Cart.java, Line: 67	    -Duplicate if condition its should be else if (cart.get(i).getClass().toString() == Dairy.class.toString()) FD

		
Category:	CS – Code Smell defect. CG – Violation of a coding guideline. Provide the guideline number. FD – Functional defect. Code will not produce the expected result. MD – Miscellaneous defect, for all other defects.
Severity:       BR - Blocker, must be fixed asap. MJ – Major, of high importance but not a Blocker LOW – Low. 
