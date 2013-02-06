(ns zp-hw1.mats)

(defn addz
	"Sum a list of numbers"
	[& more] 
		(reduce + more)
)

(defn subz
	"Subtract through a list of numbers, begining with value 0"
	[& more]
	(reduce - more)
)

(defn multz
	"Multiply up a list of numbers"
	[& more]
	(reduce * 1 more)
)