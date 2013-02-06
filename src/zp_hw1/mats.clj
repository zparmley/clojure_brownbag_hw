(ns zp-hw1.mats)

(defn addz
	"Sum a list of numbers"
	([x]
		x)
	([x y]
		(+ x y))
	([x y & more] 
		(reduce addz (addz x y) more))
)

(defn subz
	"Subtract a list of numbers in order"
	([x]
		x)
	([x y]
		(- x y))
	([x y & more]
		(reduce subz (subz x y) more))
)

(defn multz
	"Multiply through a list of numbers"
	([x]
		x)
	([x y]
		(* x y))
	([x y & more]
		(reduce multz (multz x y) more))
)