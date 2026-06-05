from linked_list import LinkedList, set_up_test_case


def test_insert_and_remove_duplicates():
  print("--- Test 1: insert() and remove_duplicates() ---")

  # Test insert at middle
  ll = LinkedList()
  for val in ['d', 'c', 'b', 'a']:
    ll.add(val)
  ll.insert('x', 2)
  node = ll.head
  for _ in range(2):
    node = node.next
  result = "PASS" if node.val == 'x' else "FAIL"
  print("insert at index 2 should give 'x': {0} (got '{1}')".format(result, node.val))

  # Test insert at head
  ll.insert('t', 0)
  result = "PASS" if ll.head.val == 't' else "FAIL"
  print("insert at index 0 should give 't': {0} (got '{1}')".format(result, ll.head.val))

  # Test remove_duplicates
  ll2 = LinkedList()
  for val in ['d', 'c', 'c', 'c', 'b', 'a', 'a']:
    ll2.add(val)
  ll2.remove_duplicates()

  seen = {}
  duplicate_found = False
  current = ll2.head
  while current:
    if seen.get(current.val, False):
      duplicate_found = True
      break
    seen[current.val] = True
    current = current.next

  result = "FAIL" if duplicate_found else "PASS"
  print("remove_duplicates should leave no duplicates: {0}".format(result))

  print()


linked_list_a = LinkedList()
linked_list_b = LinkedList()
linked_list_a.add('z')
linked_list_a.add('x')
linked_list_a.add('c')
linked_list_a.add('a')
linked_list_b.add('u')
linked_list_b.add('g')
linked_list_b.add('b')


def merge(linked_list_a, linked_list_b):
  headA = linked_list_a.head
  headB = linked_list_b.head
  totalSize = linked_list_a.size() + linked_list_b.size()
  newList = LinkedList()
  totalList = []
  for i in range (totalSize):
    if headA != None and headB != None:
      if headA.val < headB.val:
        totalList.append(headA.val)
        headA = headA.next
      elif headA.val > headB.val:
        totalList.append(headB.val)
        headB = headB.next
      elif headA.val == headB.val:
        totalList.append(headB.val)
        headB = headB.next
        headA = headA.next
    elif headA == None and headB != None:
      totalList.append(headB.val)
      headB = headB.next
    elif headA != None and headB == None:
      totalList.append(headA.val)
      headA = headA.next
  for i in range (len(totalList)):
    thingToAdd = totalList.pop()
    newList.add(thingToAdd)
  return newList

merged_linked_list = merge(linked_list_a, linked_list_b)

linked_list_1, linked_list_2 = set_up_test_case()


def test_merge_and_merge_point():
  print("--- Test 2: merge() and merge_point() ---")

  expected = "a -> b -> c -> g -> u -> x -> z -> "
  actual = str(merged_linked_list)
  result = "PASS" if actual == expected else "FAIL"
  print("merge() sorted order (a->b->c->g->u->x->z): {0}".format(result))
  print("  got: {0}".format(actual))

  test_result = merge_point(linked_list_1, linked_list_2)
  if test_result is None:
    print("merge_point() should return node 'q': FAIL (returned None)")
  else:
    result = "PASS" if test_result.val == 'q' else "FAIL"
    print("merge_point() should return node 'q': {0} (got '{1}')".format(result, test_result.val))

  print()


def merge_point(linked_list_a, linked_list_b):
  # remove dummy node and complete the function
  headA = linked_list_a.head
  while headA:
    headB = linked_list_b.head
    while headB:
      if headA == headB:
        return headA
      else:
        headB = headB.next
    headA = headA.next
  return None


test_insert_and_remove_duplicates()
test_merge_and_merge_point()
