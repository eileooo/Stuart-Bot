package core.framework

inline fun module(category: String, dsl: Set.() -> Unit) {
    var set = Set(category)
    set.apply(dsl)
    sets.add(set)
}

var sets = mutableListOf<Set>()