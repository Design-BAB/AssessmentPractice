from linked_list import LinkedList, Node

def add_two(linked_list_a, linked_list_b):
  solution = []
  headA = linked_list_a.head
  headB = linked_list_b.head
  remain = 0
  number = 0
  while headA != None and headB != None:
    number = number + remain
    number = number + headA.val
    number = number + headB.val
    if number > 9:
      remain = number // 10
      number = number % 10
    solution.append(number)
    headA = headA.next
    headB = headB.next
    #need to reset the number each run of loop
    number = 0
  while headA == None and headB != None:
    number = number + remain
    number = number + headB.val
    if number > 9:
      remain = number // 10
      number = number % 10
    solution.append(number)
    headB = headB.next
    number = 0
  while headA != None and headB == None:
    number = number + remain
    number = number + headA.val
    if number > 9:
      remain = number // 10
      number = number % 10
    solution.append(number)
    headA = headA.next
    number = 0
  linkedListSolution = LinkedList()
  for i in range(len(solution)):
    newToAdd = solution.pop()
    linkedListSolution.add(newToAdd)
  return linkedListSolution

