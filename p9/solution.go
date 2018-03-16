func isPalindrome(x int) bool {
    if x<0 {
        return false
    }
    o := x
    result := 0
    for o>0 {
        result *= 10
        result += o%10
        o /= 10
    }
    return result==x
}
