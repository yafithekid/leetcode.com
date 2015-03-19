class Solution:
    # @return a boolean
    def isValid(self,s):
        stack = []
        for c in s:
            if ((c == '(') or (c == '{') or (c == '[')):
                stack.append(c)
            elif (c == ')'):
                if ((not len(stack)) or stack.pop() != '('):
                    return False
            elif (c == '}'):
                if ((not len(stack)) or stack.pop() != '{'):
                    return False
            elif (c == ']'):
                if ((not len(stack)) or stack.pop() != '['):
                    return False
        return (not len(stack))

# print((Solution).isValid("([]){}"))